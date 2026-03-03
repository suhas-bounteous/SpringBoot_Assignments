package com.example.demo.controller;

import com.example.demo.orderentity.Order;
import com.example.demo.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(
            @RequestBody Order order) {

        Order savedOrder = orderService.create(order);

        return ResponseEntity
                .created(URI.create("/orders/" + savedOrder.getId()))
                .body(savedOrder);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(
            @PathVariable Long id) {

        Order order = orderService.getById(id);

        if (order == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(
            @PathVariable Long id,
            @RequestBody Order order) {

        Order existingOrder = orderService.getById(id);

        if (existingOrder == null) {
            return ResponseEntity.notFound().build();
        }

        Order updatedOrder = orderService.update(id, order);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {

        Order existingOrder = orderService.getById(id);

        if (existingOrder == null) {
            return ResponseEntity.notFound().build();
        }

        orderService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
