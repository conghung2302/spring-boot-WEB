package com.example.controller.App;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/test")
public class testController {
    private List<String> cartItems = new ArrayList<>();

    @PostMapping("/add-to-cart")
    @ResponseBody
    public String addToCart(@RequestParam("productId") String productId) {
        cartItems.add("Product " + productId);
        return generateCartItemsHtml();
    }

    @GetMapping("/cart")
    public String cart() {
        return "test/cart";
    }

    private String generateCartItemsHtml() {
        StringBuilder htmlBuilder = new StringBuilder();
        for (String item : cartItems) {
            htmlBuilder.append("<li>").append(item).append("</li>");
        }
        return htmlBuilder.toString();
    }

    @GetMapping("/")
    public String car1t() {
        return "test/index";
    }
}
