package com.example.entity.products.productInfor;

import com.example.entity.Views;
import com.example.entity.products.Product;
import com.example.entity.products.ProductImage;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString

public class Information {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Public.class)
    private Long id;


    @JsonView(Views.Public.class)
    private String pin;

    @JsonView(Views.Public.class)
    private String ram;

    @JsonView(Views.Public.class)
    private String os;

    @JsonView(Views.Public.class)
    private String screen;

    @JsonView(Views.Public.class)
    private String wifi;

    @JsonView(Views.Public.class)
    private String cpu;
    
    @JsonView(Views.Public.class)
    private String ssd;

    @JsonView(Views.Public.class)
    private String weight;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;


    @JsonView(Views.Product.class)
    @ManyToMany
    @JoinTable(name = "info_color",
            joinColumns = @JoinColumn(name = "info_id"),
            inverseJoinColumns = @JoinColumn(name = "color_id"))
    Set<COLOR> colorSet = new HashSet<>();
        




}
