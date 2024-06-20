package com.java.api.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.java.api.model.Order;
import com.java.api.service.OrderService;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

      // Injection du service OrderService
      @Autowired
      private OrderService orderService;

      // Méthode pour obtenir toutes les commandes
      @GetMapping
      public List<Order> getAllOrders() {
            return orderService.getAllOrders();
      }

      // Méthode pour obtenir une commande par son ID
      @GetMapping("/{id}")
      public  Order getOrderById(@PathVariable Long id) {
            Order order = orderService.getOrderById(id);
            if (order != null) {
                  return order;
            }
            return null;
      }

      // Méthode pour créer une nouvelle commande
      @PostMapping
      public Order createOrder(@RequestBody Order order) {
            Order createdOrder = orderService.createOrder(order);
            return createdOrder;
      }

      // Méthode pour mettre à jour une commande
      @PutMapping("/{id}")
      public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
            Order updatedOrder = orderService.updateOrder(id, order);
            if (updatedOrder != null) {
                  return updatedOrder;
            }
            return null;
      }

      // Méthode pour supprimer une commande
      @DeleteMapping("/{id}")
      public void deleteOrder(@PathVariable Long id) {
            orderService.deleteOrder(id);
      }

      // Méthode pour valider une commande par un agent
      @PutMapping("/{orderId}/validate/{expertId}")
      public Order validateOrder(@PathVariable Long orderId, @PathVariable Long expertId) {
            Order validatedOrder = orderService.validateOrder(orderId, expertId);
            if (validatedOrder != null) {
                  return validatedOrder;
            }
            return null;
      }
}
