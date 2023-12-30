package com.example.controller.API;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.example.entity.CartProduct;
import com.example.entity.User;
import com.example.entity.UserComment;
import com.example.entity.Views;
import com.example.entity.Cart;
import com.example.entity.products.Product;
import com.example.repo.BrandRepo;
import com.example.repo.CartProductRepo;
import com.example.repo.CartRepo;
import com.example.repo.CategoryRepo;
import com.example.repo.OrderStatusRepo;
import com.example.repo.ProductRepo;
import com.example.repo.UserCommentRepo;
import com.example.repo.UserRepo;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class CartAPI {
    @Autowired
    private UserCommentRepo userCommentRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private OrderStatusRepo orderStatusRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private BrandRepo brandRepo;

    @PostMapping("/addcmt")
    @JsonView(Views.Comment.class)
    public UserComment addcmt(@RequestParam Long idPro, HttpSession session, @RequestParam String cmt) {
        System.out.println("add cmt");
        Product product = productRepo.findById(idPro).get();
        String email = (String)session.getAttribute("email");

            

        System.out.println("Email: " + email);
        User user = userRepo.findByEmail(email);
        UserComment userComment = new UserComment();
        userComment.setComment(cmt);
        userComment.setProduct(product);
        userComment.setUser(user);
        
        user.getUserComments().add(userComment);
        userRepo.save(user);
        
        return userComment;

    }

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private CartProductRepo cartProductRepo;

    @PostMapping("/addToCart")
    @JsonView(Views.Cart.class)
    public Set<CartProduct> addCart(@RequestParam Long id, @RequestParam String color, @RequestParam int qty,
            HttpSession session) {
        System.out.println("Add to cart");
        Product product = productRepo.findById(id).get();

        User user = userRepo.findByEmail((String) session.getAttribute("email"));
    
        System.out.println("Name: " + user.getName());
        boolean exist = false;
        CartProduct existPro = null;
        for (CartProduct o : user.getCart().getCartProductSet()) {
            if (o.getProduct().getId() == id && o.getColor().equals(color)) {
                exist = true;
                existPro = o;
            }
        }
        System.out.println("exist " + exist);
        if (exist) {
            existPro.setQty(qty + existPro.getQty());
            cartProductRepo.save(existPro);

        } else {
            Cart cart = user.getCart();

            existPro = new CartProduct(null, product, cart, qty, color);

            cart.getCartProductSet().add(existPro);
            existPro.setCart(cart);
            cartProductRepo.save(existPro);
            cartRepo.save(cart);
        }

        return userRepo.findById(user.getId()).get().getCart().getCartProductSet();
    }

    @PostMapping("/editProductcart")
    @JsonView(Views.Cart.class)
    public Set<CartProduct> editProductcart(@RequestParam Long id, @RequestParam int qty, HttpSession session) {
        User user = userRepo.findByEmail((String) session.getAttribute("email"));

        for (CartProduct o : user.getCart().getCartProductSet()) {
            if (o.getId() == id) {
                o.setQty(qty);
                break;
            }
        }
        userRepo.save(user);
        return userRepo.findByEmail((String) session.getAttribute("email")).getCart().getCartProductSet();
    }

    @PostMapping("/remove-product-cart")
    @JsonView(Views.Cart.class)
    public Set<CartProduct> removeCart(@RequestParam Long id, HttpSession session) {
        cartProductRepo.deleteById(id);

        return userRepo.findByEmail((String) session.getAttribute("email")).getCart().getCartProductSet();
    }

    @GetMapping("/getCarts")
    @JsonView(Views.Cart.class)
    public List<Cart> getListCart() {
        return cartRepo.findAll();
    }
    
    
}
