// package com.example.controller.API;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.entity.Views;
// import com.example.entity.products.Product;
// import com.example.repo.ProductRepo;
// import com.fasterxml.jackson.annotation.JsonView;

// @RestController
// @RequestMapping("/api/products")
// public class SearchProductAPI {

//     @Autowired
//     private ProductRepo productRepo;
    
//     @GetMapping
//     @JsonView(Views.Product.class)
//     public List<Product> searchProducts(@RequestParam("search") String search) {
//         List<Product> searchResults = productRepo.searchProduct(search);
//         System.out.println("searching..." + search);
//         return searchResults;
//     }
// }
