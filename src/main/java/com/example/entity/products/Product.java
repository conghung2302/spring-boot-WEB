package com.example.entity.products;

import com.example.entity.*;
import com.example.entity.products.productInfor.Information;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.mapping.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString


public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Public.class)
    private Long id;

    @JsonView(Views.Public.class)
    private String name;

    @JsonView(Views.Public.class)
    private double price;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonView({Views.Product.class, Views.Cart.class})
    private Information information;

    @JsonView(Views.Public.class)
    @Column(length = 2000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    @JsonView(Views.Product.class)
    private Brand brand;

    @OneToMany(mappedBy = "product")
    @JsonView(Views.Product.class)
    Set<UserComment> userComments;


    @OneToMany(mappedBy = "product")
    Set<CartProduct> cartProductSet;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonView({Views.Product.class, Views.Cart.class})
    private Set<ProductImage> productImages;

    @OneToMany(mappedBy = "product")
    Set<ProductUser> productUsers;
}
