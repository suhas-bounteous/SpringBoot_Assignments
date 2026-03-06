package com.example.product_service.service;

import com.example.product_service.dto.Product;

public interface ProductService {

    Product getProduct(Integer productId);

    int addProduct(Product product);

}
