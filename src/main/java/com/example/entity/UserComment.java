package com.example.entity;

import java.time.LocalDateTime;

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

public class UserComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Public.class)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonView(Views.Product.class)
    User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    @JsonView(Views.Public.class)
    String comment;

    @JsonView(Views.Public.class)
    int rating;
    @JsonView(Views.Public.class)
    LocalDateTime dateTime;

}
