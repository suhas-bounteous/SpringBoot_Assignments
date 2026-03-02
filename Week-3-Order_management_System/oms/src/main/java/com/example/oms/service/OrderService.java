package com.example.oms.service;

import com.example.oms.model.Order;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public interface OrderService {

    Order createOrder(Order order);

    Order getOrder(String id);

    List<Order> getAllOrders();

    final AtomicLong orderCounter = new AtomicLong(1);

}
