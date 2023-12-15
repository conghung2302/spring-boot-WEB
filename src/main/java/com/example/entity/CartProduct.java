package com.example.entity;

import com.example.entity.products.Product;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
@Entity
@ToString

public class CartProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Public.class)
    private Long id;


    @ManyToOne
    @JsonView(Views.Cart.class)
    @JoinColumn(name = "product_id")
    Product product;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    Cart cart;
    
    @JsonView(Views.Public.class)
    private int qty;

    @JsonView(Views.Public.class)
    private String color;
}
