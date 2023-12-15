package com.example.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@ToString
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Public.class)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    @JsonView({Views.Product.class})
    // @JsonBackReference
    private Orders orders;


    @JsonView(Views.Public.class)
    private String name;

    @JsonView(Views.Public.class)
    private double price;

    @JsonView(Views.Public.class)
    private String img;

    @JsonView(Views.Public.class)
    private String color;

    @JsonView(Views.Public.class)
    private int qty;

    @JsonView(Views.Public.class)
    private String imageURL;

}
