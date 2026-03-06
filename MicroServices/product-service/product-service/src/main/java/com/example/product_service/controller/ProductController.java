package com.example.product_service.controller;

import com.example.product_service.dto.Product;
import com.example.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Integer id) {

        return productService.getProduct(id);
    }

    @PostMapping
    public int addProduct(@RequestBody Product product) {

        return productService.addProduct(product);
    }

}
