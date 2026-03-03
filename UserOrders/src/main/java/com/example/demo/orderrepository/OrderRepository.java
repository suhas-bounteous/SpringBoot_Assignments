package com.example.demo.orderrepository;

import com.example.demo.orderentity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
