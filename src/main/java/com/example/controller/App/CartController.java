package com.example.controller.App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.entity.Cart;
import com.example.entity.CartProduct;
import com.example.repo.BrandRepo;
import com.example.repo.CategoryRepo;
import com.example.repo.ProductRepo;
import com.example.repo.UserRepo;
import com.example.service.InitModel;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private InitModel initModel;
    
    @GetMapping("/cart")
    public String cart(Model model, HttpSession session) {
        String email = (String) session.getAttribute("email");
        if (email == null) {
            return "redirect:/login";
        }
        model = initModel.initHeader(model, session);

        Cart cart = userRepo.findByEmail(email).getCart();

        if (cart.getCartProductSet().size() == 0) {
            model.addAttribute("total", 0);
        } else {
            int total = 0;
            for (CartProduct o : cart.getCartProductSet()) {
                total += o.getProduct().getPrice() * o.getQty();
            }
            model.addAttribute("total", total);
            
        }
        
        model.addAttribute("cartProductSet",  cart.getCartProductSet());
        return "cart";
    }
}
