package com.example.product_service.service.impl;

import com.example.product_service.dto.Product;
import com.example.product_service.repository.ProductRepository;
import com.example.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product getProduct(Integer productId) {

        System.out.println("Fetching Product with productId : " + productId);

        Product product = productRepository.findByProductId(productId);

        return product;
    }

    @Override
    public int addProduct(Product product) {

        productRepository.save(product);

        return product.getProductId();
    }
}
