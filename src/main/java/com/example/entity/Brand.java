package com.example.entity;

import com.example.entity.products.Product;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@ToString
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Public.class)
    private Long id;

    @JsonView(Views.Public.class)
    private String name;


    @JsonView({Views.Product.class})
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "brand")
    @JsonView({Views.Category.class, Views.Brand.class})
    private Set<Product> productSet = new HashSet<>();

}
