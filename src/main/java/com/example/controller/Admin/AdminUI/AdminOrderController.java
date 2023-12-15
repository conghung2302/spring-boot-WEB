package com.example.controller.Admin.AdminUI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Orders;
import com.example.repo.OrdersRepo;

@Controller
@RequestMapping("Admin")
public class AdminOrderController {

    @Autowired
    private OrdersRepo ordersRepo;

   @GetMapping("/orders")
   public String order(Model model) {
        List<Orders> listOrders = ordersRepo.findAll();

        model.addAttribute("orderSet", listOrders);
       return "admin/orders";
   }

}