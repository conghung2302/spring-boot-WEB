package com.example.repo;

import com.example.entity.products.Product;
import com.example.entity.products.ProductUser;
import com.example.entity.products.ProductUserKey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductUserRepo extends JpaRepository<ProductUser, Long> {

    @Query(value = "SELECT * FROM product_user WHERE product_user.user_id = :i1 and product_user.product_id = :i2 ", nativeQuery = true)
    public ProductUser findProductUseById(@Param("i1") Long userId,  @Param("i2") Long productId);


    
    @Query(value = "SELECT * FROM product_user WHERE product_user.user_id = :i1", nativeQuery = true)
    public List<ProductUser> findAllProduct(@Param("i1") Long userId);
}
