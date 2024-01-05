package com.example.controller.API;

import com.example.entity.Cart;
import com.example.entity.User;
import com.example.entity.Views;
import com.example.entity.loginSignup.LoginForm;
import com.example.entity.loginSignup.SignupForm;
import com.example.repo.UserRepo;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.servlet.http.HttpSession;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")

public class Login {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/signup")
    @JsonView(Views.Public.class)
    public ResponseEntity<?> register(@RequestBody SignupForm signupForm) {
        System.out.println("Sign Up...............................");
        if (!signupForm.getPassword().equals(signupForm.getCpassword())) {
            ResponseEntity<String> responseEntity = ResponseEntity.status(404).body("Password not match");
            return responseEntity;
        }

        if (userRepo.findByEmail(signupForm.getEmail()) != null) {
            ResponseEntity<String> responseEntity = ResponseEntity.status(404).body("exist email");
            return responseEntity;
        }

        return ResponseEntity.status(200).body(userRepo.save(new User(null, signupForm.getName(),
                signupForm.getEmail(), signupForm.getPhone(),signupForm.getAddress(), signupForm.getPassword(), null, null, new Cart(), LocalDateTime.now(), null)));

    }

    @PostMapping("/login")
    @JsonView(Views.Public.class)
    public ResponseEntity<?> login(@RequestBody LoginForm loginForm, HttpSession httpSession) {
        System.out.println("Login...............................");
        User user = userRepo.findByEmail(loginForm.getEmail());

        if (user == null) {
            return ResponseEntity.status(404).body("Email not available");
        } else {
            if (user.getPassword().equals(loginForm.getPassword())) {
                httpSession.setAttribute("email", user.getEmail());
                httpSession.setAttribute("name", user.getName());
                httpSession.setAttribute("cart_id", user.getCart().getId());
                return ResponseEntity.status(200).body(user);
            }
        }
        return ResponseEntity.status(404).body("Wrong password");
    }
}
