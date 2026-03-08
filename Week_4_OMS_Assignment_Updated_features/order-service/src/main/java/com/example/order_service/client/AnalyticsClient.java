package com.example.order_service.client;

import com.example.order_service.model.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name="analytics-service")
public interface AnalyticsClient {

    @PostMapping("/analytics/update")
    void updateMetrics(@RequestBody Order order);

}
