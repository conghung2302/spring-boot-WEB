package com.example.entity;

import com.fasterxml.jackson.annotation.*;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Public.class)
    private Long id;

    @JsonView(Views.Public.class)
    private String address;

    @JsonView(Views.Public.class)
    private String phone;

    

    @ManyToOne
    @JsonView({Views.Order.class, Views.Status.class})
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
//    @JsonBackReference
    private User user;

    @ManyToOne
    @JsonView({Views.UserDetail.class, Views.Product.class, Views.Order.class})
    @JoinColumn(name = "status_id", nullable = false, referencedColumnName = "id")
//    @JsonBackReference
    private OrderStatus orderStatus;

    @JsonView({Views.UserDetail.class, Views.Order.class})
    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
//    @JsonManagedReference
    Set<OrderProduct> orderProductSet = new HashSet<>();

    @JsonView(Views.Public.class)
    private LocalDateTime dateTime;

    @JsonView(Views.Public.class)
    private int total;


}
