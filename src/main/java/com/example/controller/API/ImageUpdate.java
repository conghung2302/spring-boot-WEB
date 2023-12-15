package com.example.controller.API;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/image/")
public class ImageUpdate {
    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        System.out.println("update Image");
        if (file.isEmpty()) {
            return null;
        }

        try {
            String fileName = file.getOriginalFilename();
            String time = LocalTime.now().getHour() + LocalTime.now().getMinute() + LocalTime.now().getSecond() + "";
            String filePath = "E:\\demo\\src\\main\\resources\\static\\images\\"+ "" + time + fileName;
            System.out.println(filePath);
            file.transferTo(new File(filePath));

            return filePath;
        } catch (IOException e) {
            return "file null";
        }
    }

    @PostMapping("/upload1")
    public String saveOneImage(MultipartFile file) {
        Path path = null;
        if (file != null) {
            try {
                LocalTime currentTime = LocalTime.now();
                String time = currentTime.getHour()+currentTime.getMinute()+currentTime.getSecond() + "" + LocalDate.now();
                
                System.out.println("time now: " + currentTime.getHour()+currentTime.getMinute()+currentTime.getSecond());
                File saveFile = new ClassPathResource("E:\\demo\\src\\main\\resources\\static\\images").getFile();
                path = Paths.get(saveFile.getAbsolutePath() + File.separator + time + file.getOriginalFilename());
                System.out.println("Path: " + path);
                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                return  "/images/" + time + file.getOriginalFilename();
            } catch (Exception e) {
                e.printStackTrace();
                return "error";
            }
        }

        return null;
    }

}
