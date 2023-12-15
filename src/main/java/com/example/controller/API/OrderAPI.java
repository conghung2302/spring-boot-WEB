package com.example.controller.API;

import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Orders;
import com.example.entity.Views;
import com.example.repo.OrdersRepo;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController

@RequestMapping("/api/order")
public class OrderAPI {
    @Autowired
    private OrdersRepo ordersRepo;


    
    @GetMapping("/getAll")
    @JsonView(Views.Order.class)
    public List<Orders> getMethodName() {
        return ordersRepo.findAll();
    }
    
}
