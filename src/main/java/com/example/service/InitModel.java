package com.example.service;

import com.example.entity.CartProduct;
import com.example.repo.CategoryRepo;
import com.example.repo.UserRepo;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class InitModel {
    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private UserRepo userRepo;

    public Model initHeader(Model model) {
        model.addAttribute("categorySet", categoryRepo.findAll());
        return model;
    }

    public Model initHeader(Model model, HttpSession session) {
        model.addAttribute("categorySet", categoryRepo.findAll());

        String email = (String) session.getAttribute("email");

        if (email == null) {
            model.addAttribute("cartValue", 0);
        } else {
            int value = userRepo.findByEmail(email).getCart().getCartProductSet().size();
            model.addAttribute("cartValue", value);
            model.addAttribute("totalCart", getTotal(email));
        }
        return model;
    }

    public double getTotal(String email) {
        double sum = 0;
        for (CartProduct o : userRepo.findByEmail(email).getCart().getCartProductSet()) {
            sum += o.getQty() * o.getProduct().getPrice();
        }
        return sum;
    }
}
