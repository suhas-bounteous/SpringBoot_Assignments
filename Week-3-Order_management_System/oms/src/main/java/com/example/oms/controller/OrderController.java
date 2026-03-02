package com.example.oms.controller;

import com.example.oms.metrics.SystemMetrics;
import com.example.oms.model.Order;
import com.example.oms.model.OrderStatus;
import com.example.oms.model.OrderType;
import com.example.oms.service.AnalyticsService;
import com.example.oms.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final AnalyticsService analyticsService;
    private final SystemMetrics systemMetrics;

    public OrderController(OrderService orderService,
                           AnalyticsService analyticsService,
                           SystemMetrics systemMetrics) {
        this.orderService = orderService;
        this.analyticsService = analyticsService;
        this.systemMetrics = systemMetrics;
    }

    // ==============================
    // ORDER OPERATIONS
    // ==============================

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable String id) {
        return orderService.getOrder(id);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    // ==============================
    // ANALYTICS ENDPOINTS (Streams)
    // ==============================

    @GetMapping("/analytics/total-amount")
    public double getTotalOrderAmount() {
        return analyticsService.getTotalOrderAmount();
    }

    @GetMapping("/analytics/buy-sell")
    public Map<OrderType, Long> getBuyVsSell() {
        return analyticsService.getBuyVsSell();
    }

    @GetMapping("/analytics/top-customer")
    public String getTopCustomer() {
        return analyticsService.getTopCustomerByVolume()
                .orElse("No orders yet");
    }

    @GetMapping("/analytics/group-by-status")
    public Map<OrderStatus, List<Order>> groupByStatus() {
        return analyticsService.groupByStatus();
    }

    @GetMapping("/system/metrics")
    public Map<String, Object> getSystemMetrics() {

        return Map.of(
                "totalOrders", systemMetrics.getTotalOrders(),
                "processingOrders", systemMetrics.getProcessingOrders(),
                "completedOrders", systemMetrics.getCompletedOrders(),
                "failedOrders", systemMetrics.getFailedOrders()
        );
    }
}
