package com.example.order_service.controller;

import com.example.order_service.dto.OrderRequestDTO;
import com.example.order_service.metrics.SystemMetrics;
import com.example.order_service.model.Order;
import com.example.order_service.model.OrderStatus;
import com.example.order_service.model.OrderType;
import com.example.order_service.service.AnalyticsService;
import com.example.order_service.service.OrderService;
import com.example.order_service.util.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private AnalyticsService analyticsService;

    @Autowired
    private SystemMetrics systemMetrics;


    @PostMapping
    public ResponseEntity<String> createOrder(
            @RequestHeader("X-Role") String role,
            @RequestBody Order order) {

        if (!role.equals("ADMIN") && !role.equals("TRADER")) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Viewer cannot create orders");
        }

        orderService.createOrder(order);

        return ResponseEntity.ok("Order created");
    }



    @GetMapping("/{id}")
    public ApiResponse<Order> getOrder(@PathVariable String id) {

        Order order = orderService.getOrder(id);

        return new ApiResponse<>(
                true,
                "Order fetched successfully",
                order
        );
    }


    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

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
