package com.example.order_service.service;

import com.example.order_service.dto.Product;

public interface OrderService {

    com.example.order_service.dto.Product getProduct(Integer id);

}
