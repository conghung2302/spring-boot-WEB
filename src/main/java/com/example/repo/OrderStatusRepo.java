package com.example.repo;

import com.example.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusRepo extends JpaRepository<OrderStatus, Long> {
}
