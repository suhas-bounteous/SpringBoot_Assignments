package com.example.analytics_service.model;

public class Metrics {

    private long totalOrders;
    private long buyOrders;
    private long sellOrders;

    public long getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(long totalOrders) {
        this.totalOrders = totalOrders;
    }

    public long getBuyOrders() {
        return buyOrders;
    }

    public void setBuyOrders(long buyOrders) {
        this.buyOrders = buyOrders;
    }

    public long getSellOrders() {
        return sellOrders;
    }

    public void setSellOrders(long sellOrders) {
        this.sellOrders = sellOrders;
    }
}
