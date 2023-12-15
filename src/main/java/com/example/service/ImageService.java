package com.example.service;


import org.hibernate.grammars.hql.HqlParser.DateTimeContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.products.Product;
import com.example.entity.products.ProductImage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Service
public class ImageService {
    public static Set<ProductImage> saveImage(MultipartFile[] files, Product product) {
        Set<ProductImage> imgSet = new HashSet<>();
        for (MultipartFile img : files) {
            
            imgSet.add(new ProductImage(null, saveOneImage(img), product));            
        }

        return imgSet;
       
    }

    public static String saveOneImage(MultipartFile file) {
        System.out.println("update Image");
        if (file.isEmpty()) {
            return null;
        }

        try {
            String fileName = file.getOriginalFilename();
            String time = LocalTime.now().getHour() + LocalTime.now().getMinute() + LocalTime.now().getSecond() + "";
            String filePath = "E:\\demo\\src\\main\\resources\\static\\images\\"+ "" + time + fileName;
            System.out.println("Path12: " + filePath);
            file.transferTo(new File(filePath));

            return time + fileName;
        } catch (IOException e) {
            return "file null";
        }
    }
}
