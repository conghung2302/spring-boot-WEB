package com.example.controller.API;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonView;
import com.example.entity.Brand;
import com.example.entity.Views;
import com.example.entity.products.Product;
import com.example.entity.products.ProductImage;
import com.example.entity.products.productInfor.COLOR;
import com.example.entity.products.productInfor.Information;
import com.example.repo.BrandRepo;
import com.example.repo.CategoryRepo;
import com.example.repo.ColorRepo;
import com.example.repo.ProductRepo;
import com.example.service.ImageService;
import com.example.service.ProductService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/product")
public class ProductAPI {

    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/getEmail")
    public String getEmail(Model model, HttpSession session) {
        System.out.println("get email");
        System.out.println(session.getAttribute("email"));
        return (String) session.getAttribute("email");
    }

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private BrandRepo brandRepo;
    
    @Autowired
    ColorRepo colorRepo;

    @JsonView(Views.Product.class)
    @PostMapping("/saveOne")
    public Product addProduct(
            
            @RequestPart("files") MultipartFile[] files,
            @RequestPart("name") String name,
            @RequestPart("price") String price,
            @RequestPart("weight") String weight,
            @RequestPart("description") String description,
            @RequestPart("pin") String pin,
            @RequestPart("ram") String ram,
            @RequestPart("os") String os,
            @RequestPart("screen") String screen,
            @RequestPart("wifi") String wifi,
            @RequestPart("cpu") String cpu,
            @RequestPart("ssd") String ssd,
            @RequestPart("brandId") String brandId,
            @RequestParam("color") List<Long> color
    ) {



        Set<COLOR> setColors = new HashSet<>();
        System.out.println(color.get(0));
        for (Long o : color) {
            COLOR cl = colorRepo.findById(o).get();
            setColors.add(cl);
            
        }
        
           
            
        System.out.println("id: ");
        System.out.println("Save one");
        Information information = new Information(null, pin, ram, os, screen, wifi, cpu, ssd, weight, null, setColors);
        Brand brand = brandRepo.findById(Long.parseLong(brandId)).get();

        Product product = new Product(null, name, Double.parseDouble(price), information, description, brand, null,
                null, null, null);
        
            
        Set<ProductImage> setProductImages = ImageService.saveImage(files, product);
        product.setProductImages(setProductImages);
        information.setProduct(product);
        // information.setColorSet(colors);
        return productRepo.save(product);
    }

    @Autowired
    private ProductService productService;

    @JsonView(Views.Product.class)
    @PostMapping("/update")
    public Product updateProduct(
            @RequestPart("id") String id,
            @RequestPart("name") String name,
            @RequestPart("price") String price,
            @RequestPart("weight") String weight,
            @RequestPart("description") String description,
            @RequestPart("pin") String pin,
            @RequestPart("ram") String ram,
            @RequestPart("os") String os,
            @RequestPart("screen") String screen,
            @RequestPart("wifi") String wifi,
            @RequestPart("cpu") String cpu,
            @RequestPart("ssd") String ssd,
            @RequestParam("brandId") Long brandId,
            @RequestParam("color") List<Long> color
        ) {

            
        if (description == " ") {
            return productRepo.save(productService.updateProduct(id, name, price, weight, pin, ram, os, screen, wifi, cpu, ssd));
        } else {
            return productRepo.save(productService.updateProduct(id, name, price, weight, description, pin, ram, os, screen, wifi, cpu, ssd, brandId, color));
        }
        
    }



    @JsonView(Views.Product.class)
    @GetMapping("/addAll")
    public List<Product> addAllProduct(@RequestBody List<Product> list) {
        return productRepo.saveAll(list);
    }

    @JsonView(Views.Product.class)
    @GetMapping("/getAll")
    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    @JsonView(Views.Product.class)
    @GetMapping("/{id}")
    public Product getOne(@PathVariable("id") Long id) {
        System.out.println("Id: " + id);
        return productRepo.findById(id).get();
    }

    @JsonView(Views.Product.class)
    @PostMapping("/saveAll")
    public List<Product> addAll(@RequestBody List<Product> list) {
        return productRepo.saveAll(list);
    }

    @JsonView(Views.Product.class)
    @GetMapping("/deleteAll")
    public void deleteAll() {
        productRepo.deleteAll();
    }

    @JsonView(Views.Product.class)
    @GetMapping("/delete/{id}")
    public String deleteOne(@PathVariable Long id) {
        productRepo.deleteById(id);
        return "success";
    }

    // @PostMapping("/addImg")
    // public String uploadImage(@RequestParam MultipartFile file) {
    //     return ImageService.saveImage(file);
    // }
}
