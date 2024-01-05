package com.example.service;

import com.example.entity.Brand;
import com.example.entity.Category;
import com.example.entity.Views;
import com.example.entity.products.Product;
import com.example.entity.products.ProductImage;
import com.example.entity.products.productInfor.COLOR;
import com.example.entity.products.productInfor.Information;
import com.example.repo.BrandRepo;
import com.example.repo.CategoryRepo;
import com.example.repo.ColorRepo;
import com.example.repo.ProductRepo;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ColorRepo colorRepo;
    @Autowired
    private BrandRepo brandRepo;

    @JsonView(Views.Product.class)
    public Product updateProduct(
            String id,
            String name,
            String price,
            String weight,
            String description,
            String pin,
            String ram,
            String os,
            String screen,
            String wifi,
            String cpu,
            String ssd,
            Long brandId,
            List<Long> color
            ) {
        
        Set<COLOR> setColors = new HashSet<>();
        System.out.println(color.get(0));
        for (Long o : color) {
            COLOR cl = colorRepo.findById(o).get();
            setColors.add(cl);
            
        }
        Product product = productRepo.findById(Long.valueOf(id)).get();
        Brand brand = brandRepo.findById(brandId).get();

        product.setBrand(brand);
        product.setDescription(description);
        product.setName(name);
        product.setPrice(Double.parseDouble(price));

        Information information = product.getInformation();

        information.setCpu(cpu);
        information.setOs(os);
        information.setPin(pin);
        information.setRam(ram);
        information.setScreen(screen);
        information.setWeight(weight);
        information.setWifi(wifi);
        information.setProduct(product);
        information.setColorSet(setColors);
        product.setInformation(information);

        return productRepo.save(product);
    }

    @JsonView(Views.Product.class)
    public Product updateProduct(
            String id,
            String name,
            String price,
            String weight,
            String pin,
            String ram,
            String os,
            String screen,
            String wifi,
            String cpu,
            String ssd) {

        Product product = productRepo.findById(Long.valueOf(id)).get();
        product.setName(name);
        product.setPrice(Double.parseDouble(price));

        Information information = product.getInformation();

        information.setCpu(cpu);
        information.setOs(os);
        information.setPin(pin);
        information.setRam(ram);
        information.setScreen(screen);
        information.setWeight(weight);
        information.setWifi(wifi);
        information.setProduct(product);
        product.setInformation(information);

        return productRepo.save(product);
    }
}
