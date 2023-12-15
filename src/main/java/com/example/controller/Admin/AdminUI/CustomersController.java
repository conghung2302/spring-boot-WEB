package com.example.controller.Admin.AdminUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.User;
import com.example.entity.Views;
import com.example.repo.UserRepo;
import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("Admin/customer")
public class CustomersController {

    @Autowired
    UserRepo userRepo;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("users", userRepo.findAll());
       return "admin/customers";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepo.deleteById(id);
        return "redirect:/Admin/customer";
    }
}