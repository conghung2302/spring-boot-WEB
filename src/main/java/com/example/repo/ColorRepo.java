package com.example.repo;

import com.example.entity.products.productInfor.COLOR;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepo extends JpaRepository<COLOR, Long> {
}
