package com.example.order_service.service;

import com.example.order_service.client.AnalyticsClient;
import com.example.order_service.exception.InvalidOrderException;
import com.example.order_service.exception.OrderNotFoundException;
import com.example.order_service.metrics.SystemMetrics;
import com.example.order_service.model.Order;
import com.example.order_service.model.OrderStatus;
import com.example.order_service.repository.OrderRepository;
import com.example.order_service.util.OrderFileLogger;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private OrderFileLogger fileLogger;

    @Autowired
    private SystemMetrics metrics;

    @Autowired
    private AnalyticsClient analyticsClient;

    private final BlockingQueue<Order> orderQueue =
            new LinkedBlockingQueue<>();


    @PostConstruct
    public void startWorkers() {

        int workers = 3;

        for (int i = 0; i < workers; i++) {

            Thread worker = new Thread(() -> {

                while (true) {

                    try {

                        Order order = orderQueue.take();
                        processOrder(order);

                    } catch (InterruptedException e) {

                        Thread.currentThread().interrupt();
                    }
                }
            });

            worker.setDaemon(true);
            worker.start();
        }
    }

    @Override
    public Order createOrder(Order order) {

        if (order.getCustomerId() == null || order.getCustomerId().isBlank()) {
            throw new InvalidOrderException(
                    "Invalid order: customerId cannot be empty"
            );
        }

        if (order.getAmount() <= 0) {
            throw new InvalidOrderException(
                    "Invalid order: amount must be greater than zero"
            );
        }

        if (order.getType() == null) {
            throw new InvalidOrderException(
                    "Invalid order: order type must be BUY or SELL"
            );
        }
        order.setOrderId("ORD-" + System.currentTimeMillis());

        repository.save(order);

        System.out.println("Order saved successfully: " + order.getOrderId());

        metrics.incrementTotal();

        orderQueue.offer(order);

        try {

            analyticsClient.updateMetrics(order);
            System.out.println("Analytics updated for order: " + order.getOrderId());

        } catch (Exception e) {

            System.out.println("Analytics service unavailable. Order still saved.");
        }

        return order;
    }


    private void processOrder(Order order) {

        try {

            metrics.incrementProcessing();
            order.setStatus(OrderStatus.PROCESSING);

            Thread.sleep(2000);

            order.setStatus(OrderStatus.COMPLETED);
            repository.save(order);


            metrics.incrementCompleted();

            fileLogger.log(order);

        } catch (Exception e) {

            order.setStatus(OrderStatus.FAILED);
            metrics.incrementFailed();

        } finally {

            metrics.decrementProcessing();
        }
    }


    @Override
    public Order getOrder(String id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new OrderNotFoundException(
                                "Order with id " + id + " not found"
                        ));
    }


    @Override
    public List<Order> getAllOrders() {

        return repository.findAll();
    }


    public int getQueueSize() {

        return orderQueue.size();
    }
}
