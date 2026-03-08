package com.example.order_service.dto;

import com.example.order_service.model.OrderType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


public class OrderRequestDTO {

    @NotBlank(message = "Customer ID cannot be empty")
    private String customerId;

    @NotNull(message = "Order type must be BUY or SELL")
    private OrderType type;

    @Positive(message = "Amount must be greater than zero")
    private double amount;


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
}
