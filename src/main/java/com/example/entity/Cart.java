package com.example.entity;

import java.util.HashSet;
import java.util.Set;

import com.example.entity.Views.Order;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Public.class)
    private Long id;

    
    @OneToOne(mappedBy = "cart")
    User user;

    @JsonView(Views.Cart.class)
    @OneToMany(mappedBy = "cart")
    Set<CartProduct> cartProductSet = new HashSet<>();


}
