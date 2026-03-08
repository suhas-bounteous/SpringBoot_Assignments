package com.example.order_service.service;

import com.example.order_service.model.Order;
import com.example.order_service.model.OrderStatus;
import com.example.order_service.model.OrderType;
import com.example.order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnalyticsService {

    private final OrderRepository repository;

    public AnalyticsService(OrderRepository repository) {
        this.repository = repository;
    }

    public double getTotalOrderAmount() {
        return repository.findAll()
                .stream()
                .mapToDouble(Order::getAmount)
                .sum();
    }

    public Map<OrderType, Long> getBuyVsSell() {
        return repository.findAll()
                .stream()
                .collect(Collectors.groupingBy(
                        Order::getType,
                        Collectors.counting()
                ));
    }

    public Optional<String> getTopCustomerByVolume() {
        return repository.findAll()
                .stream()
                .collect(Collectors.groupingBy(
                        Order::getCustomerId,
                        Collectors.summingDouble(Order::getAmount)
                ))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }

    public Map<OrderStatus, List<Order>> groupByStatus() {
        return repository.findAll()
                .stream()
                .collect(Collectors.groupingBy(Order::getStatus));
    }
}
