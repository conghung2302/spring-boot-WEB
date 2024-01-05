package com.example.controller.Admin.AdminUI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Category;
import com.example.entity.products.Product;
import com.example.repo.CategoryRepo;
import com.example.repo.ColorRepo;
import com.example.repo.ProductRepo;

@Controller
@RequestMapping("Admin")
public class ProductController {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @GetMapping("/product")
    public String product(Model model) {
        List<Product> productSet = productRepo.findAll();
        model.addAttribute("productSet", productSet);
        return "admin/products";
    }

    @Autowired
    private ColorRepo colorRepo;

    @GetMapping("/product/{id}")
    public String productDetail(Model model, @PathVariable Long id) {
        Product product = productRepo.findById(id).get();
        List<Category> categories = categoryRepo.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("p", product);
        model.addAttribute("colorSet", colorRepo.findAll());
        return "admin/edit-product";
    }


    @GetMapping("/product/add")
    public String addProduct(Model model) {
        model.addAttribute("colorSet", colorRepo.findAll());
        return "admin/add-product";
    }

    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productRepo.deleteById(id);
        return "redirect:/Admin/product";
    }


}
