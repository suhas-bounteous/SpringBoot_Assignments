package com.example.oms.service;

import com.example.oms.exception.InvalidOrderException;
import com.example.oms.exception.OrderNotFoundException;
import com.example.oms.metrics.SystemMetrics;
import com.example.oms.model.Order;
import com.example.oms.model.OrderStatus;
import com.example.oms.repository.OrderRepository;
import com.example.oms.util.OrderFileLogger;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final OrderFileLogger fileLogger;
    private final SystemMetrics metrics;

    private final BlockingQueue<Order> orderQueue =
            new LinkedBlockingQueue<>();

    public OrderServiceImpl(OrderRepository repository,
                            OrderFileLogger fileLogger,
                            SystemMetrics metrics) {
        this.repository = repository;
        this.fileLogger = fileLogger;
        this.metrics = metrics;
    }

    // Start worker threads automatically
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

        if (order.getAmount() <= 0) {
            throw new InvalidOrderException("Amount must be greater than 0");
        }

        repository.save(order);
        metrics.incrementTotal();

        orderQueue.offer(order);

        return order;
    }

    private void processOrder(Order order) {

        try {
            metrics.incrementProcessing();
            order.setStatus(OrderStatus.PROCESSING);

            Thread.sleep(2000);

            order.setStatus(OrderStatus.COMPLETED);

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
                .orElseThrow(() -> new OrderNotFoundException("Order not found"));
    }

    @Override
    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    public int getQueueSize() {
        return orderQueue.size();
    }
}
