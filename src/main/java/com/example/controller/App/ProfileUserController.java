package com.example.controller.App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.User;
import com.example.repo.UserRepo;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProfileUserController {

    @Autowired
    private UserRepo userRepo;
    @PostMapping("profile/address/update")
    public String changeAddress(Model model,  @RequestParam String newaddress, HttpSession session) {
        String email = (String) session.getAttribute("email");
        User user = userRepo.findByEmail(email);
        user.setAddress(newaddress);
        userRepo.save(user);
        System.out.println(newaddress);
        return "redirect:/my-account";
    }

    @PostMapping("profile/password/update")
    public String changePass(Model model, @RequestParam String pass, @RequestParam String cpass, HttpSession session) {
        String email = (String) session.getAttribute("email");

        if (!pass.equals(cpass))
            return "redirect:/my-account";
        System.out.println(pass);
        User user = userRepo.findByEmail(email);
        user.setPassword(pass);
        userRepo.save(user);
        return "redirect:/my-account";
    }
}
