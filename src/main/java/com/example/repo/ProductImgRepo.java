package com.example.repo;

import com.example.entity.products.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImgRepo extends JpaRepository<ProductImage, Long> {
}
