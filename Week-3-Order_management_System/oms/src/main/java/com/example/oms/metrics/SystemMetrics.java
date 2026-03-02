package com.example.oms.metrics;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class SystemMetrics {

    private final AtomicInteger totalOrders = new AtomicInteger();
    private final AtomicInteger processingOrders = new AtomicInteger();
    private final AtomicInteger completedOrders = new AtomicInteger();
    private final AtomicInteger failedOrders = new AtomicInteger();

    public void incrementTotal() {
        totalOrders.incrementAndGet();
    }

    public void incrementProcessing() {
        processingOrders.incrementAndGet();
    }

    public void decrementProcessing() {
        processingOrders.decrementAndGet();
    }

    public void incrementCompleted() {
        completedOrders.incrementAndGet();
    }

    public void incrementFailed() {
        failedOrders.incrementAndGet();
    }

    public int getTotalOrders() {
        return totalOrders.get();
    }

    public int getProcessingOrders() {
        return processingOrders.get();
    }

    public int getCompletedOrders() {
        return completedOrders.get();
    }

    public int getFailedOrders() {
        return failedOrders.get();
    }
}
