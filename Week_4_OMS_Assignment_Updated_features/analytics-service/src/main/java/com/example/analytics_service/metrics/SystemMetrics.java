package com.example.analytics_service.metrics;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class SystemMetrics {

    private AtomicLong totalOrders = new AtomicLong(0);
    private AtomicLong buyOrders = new AtomicLong(0);
    private AtomicLong sellOrders = new AtomicLong(0);

    public void incrementTotal(){
        totalOrders.incrementAndGet();
    }

    public void incrementBuy(){
        buyOrders.incrementAndGet();
    }

    public void incrementSell(){
        sellOrders.incrementAndGet();
    }

    public long getTotalOrders(){
        return totalOrders.get();
    }

    public long getBuyOrders(){
        return buyOrders.get();
    }

    public long getSellOrders(){
        return sellOrders.get();
    }

}
