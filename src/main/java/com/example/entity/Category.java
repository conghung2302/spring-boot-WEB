package com.example.entity;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@ToString
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Public.class)
    private Long id;

    @JsonView(Views.Public.class)
    private String name;


    @JsonView(Views.Category.class)
    
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)    
    private Set<Brand> brandSet;
}
