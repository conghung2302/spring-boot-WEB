package com.example.controller.Admin.AdminUI;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.OrderProduct;
import com.example.entity.Orders;
import com.example.repo.OrdersRepo;

@Controller
@RequestMapping("Admin")
public class HomeController {

    @Autowired
    private OrdersRepo ordersRepo;


    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("orderSize", ordersRepo.findAll().size());

        return "admin/index";
    }
}
