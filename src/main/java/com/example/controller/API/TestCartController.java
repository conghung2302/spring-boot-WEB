// package com.example.controller.API;

// import com.example.entity.*;
// import com.example.entity.products.Product;
// import com.example.repo.*;
// import com.fasterxml.jackson.annotation.JsonView;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import java.util.Set;

// @RestController
// public class TestCartController {
//     @Autowired
//     private UserRepo userRepo;

//     @Autowired
//     private OrdersProductRepo ordersProductRepo;

//     @Autowired
//     private ProductRepo productRepo;

//     @Autowired
//     private OrderStatusRepo orderStatusRepo;

//     @Autowired
//     private OrdersRepo ordersRepo;


//     @GetMapping("/addCart1")
//     @JsonView(Views.UserDetail.class)
//         public User addProduct(@RequestParam Long idPro, @RequestParam String email) {
//         System.out.println("ID Pro: " + idPro);
//         System.out.println("Email: " + email);

//         User user = userRepo.findByEmail(email);
//         Product product = productRepo.findById(idPro).get();
//         if (!user.getOrders().isEmpty()) {
//             Orders orders = user.getOrders().stream().reduce((one, two) -> two).get();
//             System.out.println("Order ID: " + orders.getOrderStatus().getId());
//             if (orders.getOrderStatus().getId() == 1L) {
//                 Orders orders2 = new Orders();
//                 orders2.setOrderStatus(orderStatusRepo.findById(2L).get());
//                 orders2.setUser(user);
//                 OrderProduct orderProduct = createOrderProduct(product, orders2, 1);
//                 orders2.getOrderProductSet().add(orderProduct);
//                 ordersRepo.save(orders2);

// //                User user2 = userRepo.findByEmail(email);
// //                user2.getOrders().add(orders2);
// //                userRepo.save(user);
// //                Orders orders1 = userRepo.findByEmail(email).getOrders().stream().reduce((one, two) -> two).get();

// //                ordersProductRepo.save(orderProduct);
//             } else {
//                 OrderProduct orderProduct = createOrderProduct(product, orders, 1);
//                 ordersProductRepo.save(orderProduct);
//             }


//         } else {
//             Orders orders = new Orders();
//             orders.setOrderStatus(orderStatusRepo.findById(2L).get());
//             orders.setUser(user);


//             user.getOrders().add(orders);
//             OrderProduct orderProduct = createOrderProduct(product, orders, 1);
//             ordersProductRepo.save(orderProduct);
// //            userRepo.save(user);

//         }
//         return userRepo.findByEmail(email);
//     }

//     public OrderProduct createOrderProduct(Product product, Orders orders, int quantity) {
//         for (OrderProduct o : orders.getOrderProductSet()) {
//             if (o.getProduct().getId() == product.getId()) {
//                 o.setQuantity(o.getQuantity() + quantity);
//                 return o;
//             }
//         }
//         OrderProduct orderProduct = new OrderProduct();
//         orderProduct.setQuantity(quantity);
//         orderProduct.setProduct(product);
//         orderProduct.setOrders(orders);
//         return orderProduct;
//     }

//     @GetMapping("/checkout1")
//     @JsonView(Views.Public.class)
//     public Set<Orders> checkOut(@RequestParam String email) {
//         User user = userRepo.findByEmail(email);
//         System.out.println(user.getName());
//         Orders orders = user.getOrders().stream().reduce((one, two) -> two).get();
//         System.out.println("STATUS: " + orders.getOrderStatus().getStatus());
//         if (orders.getOrderStatus().getStatus().equals("NotYet")) {
//             orders.setOrderStatus(orderStatusRepo.findById(1L).get());
//             userRepo.save(user);
//         }
// //        return "OK";
//         return  user.getOrders();
//     }



// }
