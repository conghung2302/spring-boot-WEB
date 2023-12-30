package com.example.controller.App;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Cart;
import com.example.entity.CartProduct;
import com.example.entity.OrderProduct;
import com.example.entity.OrderStatus;
import com.example.entity.Orders;
import com.example.entity.User;
import com.example.repo.CartProductRepo;
import com.example.repo.CartRepo;
import com.example.repo.OrderStatusRepo;
import com.example.repo.OrdersRepo;
import com.example.repo.UserRepo;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.server.PathParam;

@Controller
public class OrderController {

    @Autowired
    private OrdersRepo ordersRepo;

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private OrderStatusRepo orderStatusRepo;

    @Autowired
    private CartProductRepo cartProductRepo;


    @PostMapping("cart/checkout")
    public String order(@RequestParam String address, @RequestParam String phone, HttpSession session) {
        System.out.println("checkout");
        String email = (String) session.getAttribute("email");
        User user = userRepo.findByEmail(email);

        OrderStatus orderStatus = orderStatusRepo.findById(1L).get();
        Orders orders = new Orders(null, address, phone, user, orderStatus , null, LocalDateTime.now(), 0);
        Set<CartProduct> cartProductSet = user.getCart().getCartProductSet();

        int total_= 0 ;
        Set<OrderProduct> orderProducts = new HashSet<>();
        for (CartProduct o : cartProductSet) {
            OrderProduct orderProduct = new OrderProduct(null, orders, o.getProduct().getName(), o.getQty() * o.getProduct().getPrice(), phone, o.getColor(), o.getQty(), o.getProduct().getProductImages().iterator().next().getUrl());
            total_ += o.getQty() * o.getProduct().getPrice();
            orderProducts.add(orderProduct);
            cartProductRepo.delete(o);
        }
        
        
        orders.setTotal(total_);
        orders.setOrderProductSet(orderProducts);
        ordersRepo.save(orders);
        
        return "redirect:/";
    }


}
