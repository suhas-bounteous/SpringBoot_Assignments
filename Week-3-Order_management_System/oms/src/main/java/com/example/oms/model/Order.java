package com.example.oms.model;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.example.oms.service.OrderService.orderCounter;

public class Order {

    private String orderId;
    private String customerId;
    private OrderType type;
    private double amount;
    private OrderStatus status;
    private LocalDateTime createdAt;

    public Order() {
        this.orderId = "ORD-" + String.format("%05d", orderCounter.getAndIncrement());;
        this.createdAt = LocalDateTime.now();
        this.status = OrderStatus.NEW;
    }

    public Order(String customerId, OrderType type, double amount) {
        this();
        this.customerId = customerId;
        this.type = type;
        this.amount = amount;
    }

    // Getters & Setters

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", type=" + type +
                ", amount=" + amount +
                ", status=" + status +
                ", createdAt=" + createdAt +
                '}';
    }
}
