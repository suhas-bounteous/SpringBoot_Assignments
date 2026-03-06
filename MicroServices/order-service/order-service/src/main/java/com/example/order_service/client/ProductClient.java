package com.example.order_service.client;

import com.example.order_service.dto.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "product-service")
public interface ProductClient {

    @GetMapping("/product/{id}")
    Product getProduct(@PathVariable Integer id);

}
