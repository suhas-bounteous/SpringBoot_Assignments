package com.example.analytics_service.controller;

import com.example.analytics_service.model.Order;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

    private int totalOrders = 0;
    private int buyOrders = 0;
    private int sellOrders = 0;
    private double totalTradeValue = 0;

    @PostMapping("/update")
    public void updateMetrics(@RequestBody Order order) {

        System.out.println("Received order in analytics: " + order.getOrderId());

        totalOrders++;

        if ("BUY".equalsIgnoreCase(order.getType())) {
            buyOrders++;
        }

        if ("SELL".equalsIgnoreCase(order.getType())) {
            sellOrders++;
        }

        totalTradeValue += order.getAmount();
    }

    @GetMapping("/metrics")
    public Map<String, Object> getMetrics() {

        Map<String, Object> metrics = new HashMap<>();

        metrics.put("totalOrders", totalOrders);
        metrics.put("buyOrders", buyOrders);
        metrics.put("sellOrders", sellOrders);
        metrics.put("totalTradeValue", totalTradeValue);

        return metrics;
    }
}
