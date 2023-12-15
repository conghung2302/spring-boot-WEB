package com.example.repo;

import com.example.entity.CartProduct;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartProductRepo extends JpaRepository<CartProduct, Long> {
}
