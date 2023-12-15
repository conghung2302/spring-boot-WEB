package com.example.entity.products.productInfor;

import com.example.entity.Views;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class COLOR {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Public.class)
    private Long id;

    @JsonView(Views.Public.class)
    private String name;

    @ManyToMany(mappedBy = "colorSet")
    Set<Information> informationSet;
}
