package com.example.controller.App;

import com.example.entity.Brand;
import com.example.entity.Views;
import com.example.entity.products.Product;
import com.example.repo.BrandRepo;
import com.example.repo.CategoryRepo;
import com.example.repo.ProductRepo;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/products")
public class SearchController {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private BrandRepo brandRepo;

    @GetMapping("/search")
    public String searchProducts(@RequestParam("search") String search, Model model) {
        List<Product> searchResults = productRepo.searchProduct(search);
        model.addAttribute("productSet", searchResults);
        return "shop";
    }

    @GetMapping("/sort")
    public String sortProduct(@RequestParam(defaultValue = "") String type, @RequestParam(defaultValue = "") Long id,
            @RequestParam("fill") String fill, Model model) {
        List<Product> productSet = new ArrayList<>();
        if (type.equals("category")) {

            Set<Brand> list = categoryRepo.findById(id).get().getBrandSet();
            for (Brand o : list) {
                productSet.addAll(o.getProductSet());
            }

        } else if (type.equals("brand")) {
            Set<Product> list = brandRepo.findById(id).get().getProductSet();
            productSet.addAll(list);
        } else {
            productSet = productRepo.findAll();
        }

        if (fill.equals("asc")) {
            Collections.sort(productSet, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return (int) (o1.getPrice() - o2.getPrice());
                }
            });
        } else {
            Collections.sort(productSet, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return (int) (o2.getPrice() - o1.getPrice());
                }
            });
        }

        model.addAttribute("productSet", productSet);
        return "shop";
    }

}
