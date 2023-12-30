package com.example.controller.Admin.AdminUI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.OrderStatus;
import com.example.entity.Orders;
import com.example.repo.OrderStatusRepo;
import com.example.repo.OrdersRepo;

@Controller
@RequestMapping("Admin")
public class AdminOrderController {

    @Autowired
    private OrdersRepo ordersRepo;

    @Autowired
    private OrderStatusRepo orderStatusRepo;

    @GetMapping("/orders")
    public String order(Model model) {
        List<Orders> listOrders = ordersRepo.findAll();

        model.addAttribute("orderSet", listOrders);
        return "admin/orders";
    }

    @GetMapping("/confirm/{id}")
    public String order(@PathVariable Long id) {
        Orders orders = ordersRepo.findById(id).get();
        OrderStatus orderStatus = orderStatusRepo.findById(2L).get();
        orders.setOrderStatus(orderStatus);
        ordersRepo.save(orders);
        return "redirect:/Admin/orders";
    }
}