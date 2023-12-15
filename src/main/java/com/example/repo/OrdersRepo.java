package com.example.repo;

import com.example.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepo extends JpaRepository<Orders, Long> {
}
