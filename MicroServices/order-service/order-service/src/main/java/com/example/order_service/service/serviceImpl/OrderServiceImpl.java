package com.example.order_service.service.serviceImpl;

import com.example.order_service.dto.Product;
import com.example.order_service.service.OrderService;
import com.example.order_service.client.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    ProductClient productClient;

    public Product getProduct(Integer id) {

        return productClient.getProduct(id);
    }

}
