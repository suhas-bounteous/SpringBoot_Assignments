package com.example.demo.service;

import com.example.demo.orderentity.Order;
import com.example.demo.orderrepository.OrderRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository,
                        UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public Order create(Order order) {

        if (!userRepository.existsById(Math.toIntExact(order.getUserId()))) {
            throw new RuntimeException(
                    "User not found with id: " + order.getUserId());
        }

        return orderRepository.save(order);
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order getById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order update(Long id, Order updatedOrder) {

        Order existing = orderRepository.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setProductName(updatedOrder.getProductName());
        existing.setQuantity(updatedOrder.getQuantity());
        existing.setPrice(updatedOrder.getPrice());
        existing.setUserId(updatedOrder.getUserId());

        return orderRepository.save(existing);
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
