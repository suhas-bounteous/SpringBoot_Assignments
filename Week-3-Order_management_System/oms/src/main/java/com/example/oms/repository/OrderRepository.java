package com.example.oms.repository;

import com.example.oms.model.Order;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class OrderRepository {

    private final Map<String, Order> orderStore = new ConcurrentHashMap<>();

    public void save(Order order) {
        orderStore.put(order.getOrderId(), order);
    }

    public Optional<Order> findById(String id) {
        return Optional.ofNullable(orderStore.get(id));
    }

    public List<Order> findAll() {
        return new ArrayList<>(orderStore.values());
    }
}
