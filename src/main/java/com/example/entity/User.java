package com.example.entity;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Public.class)
    private Long id;

    @JsonView(Views.Public.class)
    private String name;
    @JsonView(Views.Public.class)
    private String email;
    @JsonView(Views.Public.class)
    private String phone;
    @JsonView(Views.Public.class)
    private String address;
    @JsonView(Views.Public.class)
    private String password;

    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonView(Views.UserDetail.class)
    private Set<Orders> orderSet = new HashSet<>();

    @OneToMany(mappedBy = "user")
    Set<UserComment> userComments;

    @JsonView({Views.Cart.class, Views.UserDetail.class})
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    Cart cart = new Cart();

    @JsonView(Views.Public.class)
    private LocalDateTime date;
}
