package com.example.analytics_service.service;

import com.example.analytics_service.metrics.SystemMetrics;
import com.example.analytics_service.model.Metrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsService {

    @Autowired
    private SystemMetrics metrics;

    public Metrics getMetrics(){

        Metrics m = new Metrics();

        m.setTotalOrders(metrics.getTotalOrders());
        m.setBuyOrders(metrics.getBuyOrders());
        m.setSellOrders(metrics.getSellOrders());

        return m;
    }

}
