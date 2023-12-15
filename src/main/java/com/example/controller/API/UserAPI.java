package com.example.controller.API;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.entity.Views;
import com.example.repo.UserRepo;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@RequestMapping("/api/user")
public class UserAPI {
    
    @Autowired
    private UserRepo userRepo;


    @GetMapping("/getAll")
    @JsonView(Views.UserDetail.class)
    public List<User> getAllUser() {
        return userRepo.findAll();
    }


    
}
