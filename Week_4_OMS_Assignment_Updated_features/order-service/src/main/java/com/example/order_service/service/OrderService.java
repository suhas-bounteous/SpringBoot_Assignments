package com.example.order_service.service;

import com.example.order_service.model.Order;

import java.util.List;

public interface OrderService {

    Order createOrder(Order order);

    Order getOrder(String id);

    List<Order> getAllOrders();

}
