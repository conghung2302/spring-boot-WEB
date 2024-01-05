package com.example.entity.products;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Embeddable
public class ProductUserKey implements Serializable {

    @Column(name = "product_id")
    Long productId;

    @Column(name = "user_id")
    Long UserId;
    
}