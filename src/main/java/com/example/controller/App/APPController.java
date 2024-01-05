package com.example.controller.App;

import com.example.entity.Brand;
import com.example.entity.Cart;
import com.example.entity.CartProduct;
import com.example.entity.Category;
import com.example.entity.User;
import com.example.entity.UserComment;
import com.example.entity.products.Product;
import com.example.entity.products.ProductImage;
import com.example.entity.products.ProductUser;
import com.example.entity.products.ProductUserKey;
import com.example.repo.*;
import com.example.service.InitModel;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class APPController {
    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ProductUserRepo productUserRepo;


    @Autowired
    private InitModel initModel;

    @Autowired
    private BrandRepo brandRepo;

    @Autowired
    private ProductRepo productRepo;


    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        System.out.println("Home-----------");
        String email = (String) session.getAttribute("email");

        User user = userRepo.findByEmail(email);
        
        
        System.out.println();
        model = initModel.initHeader(model, session);
        if (user != null) {
            List<ProductUser> productUsers = productUserRepo.findAllProduct(user.getId());
            model.addAttribute("setProduct", productUsers);
        }
        


        List<Product> productUsers2 = productRepo.findAll().subList(0, 6);
        model.addAttribute("setProduct2", productUsers2);
        return "index";
    }

    @GetMapping("/logout")
    public String logout(Model model, HttpSession session) {
        session.removeAttribute("name");
        session.removeAttribute("email");
        model = initModel.initHeader(model, session);
        return "redirect:/";
    }

    @GetMapping("/product/brand/{id}")
    public String categoryShop(Model model, @PathVariable Long id, HttpSession session) {
        model = initModel.initHeader(model, session);

        Set<Product> productSet = brandRepo.findById(id).get().getProductSet();
        

        model.addAttribute("productSet", productSet);
        return "shop";
    }

    

    @GetMapping("/product/category/{id}")
    public String categoryShop2(Model model, @PathVariable Long id, HttpSession session) {
        model = initModel.initHeader(model, session);

        Set<Product> productSet = new HashSet<>();

        Set<Brand> list = categoryRepo.findById(id).get().getBrandSet();
        for (Brand o : list) {
            // System.out.println(o.getName());
            productSet.addAll(o.getProductSet());
        }
        model.addAttribute("productSet", productSet);
        return "shop";
    }

    


    @GetMapping("/shop/{id}")
    public String shopHome(Model model, HttpSession session, @PathVariable int id) {
        System.out.println(id);
        model = initModel.initHeader(model, session);
        
        List<Product> productSet = productRepo.findAll();
        if (id > productSet.size()/3 + 1) {
            model.addAttribute("productSet", productSet);
            return "shop";
        } else {
            model.addAttribute("productSet", productSet.subList(id, id+3));
        }
        return "shop";
        
    }


    
    @GetMapping("/shop")
    public String shopHome1(Model model, HttpSession session) {
        
        model = initModel.initHeader(model, session);
        
        List<Product> productSet = productRepo.findAll();
    
        model.addAttribute("productSet", productSet);
        return "shop";
    }


    

    @GetMapping("/product/{id}")
    public String productDetail(@PathVariable Long id, Model model, HttpSession session) {
        model = initModel.initHeader(model, session);
        model.addAttribute("product", productRepo.findById(id).get());
        // System.out.println(id);
        String email = (String) session.getAttribute("email");  
        System.out.println(email);
        if (email != null) {
            
            User user = userRepo.findByEmail(email);
            Product product = productRepo.findById(id).get();

            System.out.println("IMG: " + product.getProductImages().size());

            for (ProductImage o : product.getProductImages()) {
                System.out.println(o.getUrl());
            }
            System.out.println(user.getId());
            System.out.println(product.getId());
            
            ProductUser productUser = productUserRepo.findProductUseById(user.getId(), product.getId()); 

            if (productUser != null) {
                productUser.setView(productUser.getView() + 1);
                productUserRepo.save(productUser);
            } else {
                ProductUser productUser2 = new ProductUser(new ProductUserKey(product.getId(), user.getId()), product, user, 1);
                productUserRepo.save(productUser2);
            }
           

        }
        return "product-details-variable2";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model = initModel.initHeader(model);
        return "login-register";
    }
    
    @GetMapping("/checkout")
    public String checkout(Model model, HttpSession session) {
        model = initModel.initHeader(model, session);

        String email = (String) session.getAttribute("email");
        
        User user = userRepo.findByEmail(email);

        Set<CartProduct> cartProductSet = user.getCart().getCartProductSet();

        int subtotal = 0;
        for (CartProduct o : cartProductSet) {
            subtotal += o.getProduct().getPrice() * o.getQty();
        }
        model.addAttribute("cartProductSet", cartProductSet);
        model.addAttribute("subtotal", subtotal);
        model.addAttribute("total", subtotal + 70);
        return "checkout";
    }

    @GetMapping("/my-account")
    public String myAccount(Model model, HttpSession session) {
        model = initModel.initHeader(model, session);

        String email = (String) session.getAttribute("email");
        
        User user = userRepo.findByEmail(email);

        model.addAttribute("orderSet", user.getOrderSet());
        model.addAttribute("user", user);
        return "my-account";
    }

    @GetMapping("/contact")
    public String contract(Model model, HttpSession session) {
        model = initModel.initHeader(model, session);
        return "contact-us";
    }

    @GetMapping("/about")
    public String about(Model model, HttpSession session) {
        model = initModel.initHeader(model, session);
        return "about-us";
    }

    @Autowired
    private UserCommentRepo userCommentRepo;

    @Autowired
    private UserRepo userRepo;
    // @PostMapping("/addcmt")
    // public UserComment addcmt(@RequestParam Long idPro, @RequestParam Long
    // idUser, @RequestParam String cmt) {
    // System.out.println("add comment");
    // Product product = productRepo.findById(idPro).get();
    // User user = userRepo.findById(idUser).get();
    //
    // UserComment userComment = new UserComment();
    // userComment.setComment(cmt);
    // userComment.setProduct(product);
    // userComment.setUser(user);
    //
    // userCommentRepo.save(userComment);
    //
    // return userComment;
    // }


    
    @PostMapping("/comment")
    public String addComment(@RequestParam String cmt, @RequestParam Long id, @RequestParam Integer rating, HttpSession session) {
        System.out.println(cmt);
        System.out.println(id);
        System.out.println(rating);


        Product product = productRepo.findById(id).get();
        String email = (String)session.getAttribute("email");

        if (email == null) {
            return "redirect:/login";
        }
        System.out.println("Email: " + email);
        User user = userRepo.findByEmail(email);
        UserComment userComment = new UserComment();
        userComment.setComment(cmt);
        userComment.setDateTime(LocalDateTime.now());
        userComment.setRating(rating);
        userComment.setProduct(product);
        userComment.setUser(user);

        userCommentRepo.save(userComment);


        return "redirect:/product/" + id;
    }

}
