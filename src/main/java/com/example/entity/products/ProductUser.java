package com.example.entity.products;

import java.time.LocalDateTime;

import com.example.entity.User;
import com.example.entity.Views;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString

public class ProductUser {


    @EmbeddedId
    ProductUserKey id;

    @ManyToOne
    @MapsId("product_id")
    @JsonView(Views.Public.class)
    @JoinColumn(name = "product_id")
    Product product;

    @ManyToOne
   
    @MapsId("user_id")
    
    @JoinColumn(name = "user_id")
    User user;

    @JsonView(Views.Public.class)
    int view;
}
