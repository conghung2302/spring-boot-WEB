package com.example.controller.API;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.products.Product;
import com.example.repo.ProductRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class SearchAPI {

    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/search")
    public List<Product> getProduct(@RequestParam String p) {
        List<Product> listProduct = productRepo.searchProduct(p);
        return listProduct;
    }
    
}
