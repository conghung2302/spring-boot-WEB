package com.example.controller.Admin.AdminUI;


import java.text.DecimalFormat;
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
import com.example.repo.ProductRepo;
import com.example.repo.UserRepo;

@Controller
@RequestMapping("Admin")
public class HomeController {

    @Autowired
    private OrdersRepo ordersRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/")
    public String index(Model model) {

        List<Orders> orders = ordersRepo.findAll();

        double sum = 0;
        for (Orders o : orders) {
            sum += o.getTotal();
        }

        double roundedNumber = Math.round(sum * 100.0) / 100.0;
        System.out.println(roundedNumber);
        model.addAttribute("orderSize", orders.size());
        model.addAttribute("revenue", roundedNumber); 
        model.addAttribute("userSize", userRepo.findAll().size());
        model.addAttribute("proSize", productRepo.findAll().size());

        return "admin/index";
    }
}
