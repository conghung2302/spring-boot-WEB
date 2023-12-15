package com.example.controller.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.repo.CategoryRepo;
import com.fasterxml.jackson.annotation.JsonView;
import com.example.entity.Category;
import com.example.entity.Views;

@RestController
@RequestMapping("/api/category")

public class CategoryAPI {
    @Autowired
    private CategoryRepo categoryRepo;

    @JsonView(Views.Category.class)
    @GetMapping("/getAll")
    public List<Category> getAllCategory() {
        return categoryRepo.findAll();
    }

    @JsonView(Views.Category.class)
    @GetMapping("/getOne/{id}")
    public Category getOneCategory(@PathVariable Long id) {
        return categoryRepo.findById(id).get();
    }


    
    @GetMapping("/saveAll")
    public List<Category> saveAllCategory(@RequestBody List<Category> list) {
        
        return categoryRepo.saveAll(list);
    }

    @JsonView(Views.Category.class)
    @GetMapping("/saveOne")
    public Category saveOneCategory(@RequestBody Category category) {
        return categoryRepo.save(category);
    }
}