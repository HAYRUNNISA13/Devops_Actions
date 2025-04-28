package com.example.demo.Controller;

import com.example.demo.Model.Order;
import com.example.demo.Model.Product;
import com.example.demo.Model.Customer;
import com.example.demo.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/orders")
    public List<Order> showOrderList() {
        return orderService.getAllOrders();
    }

    @PostMapping("/create")
    public String createOrder(@RequestBody Order order) throws ProductNotFoundException, CustomerNotFoundException {
        try {
            orderService.saveOrder(order);
            return "The order was successfully added";
        } catch (OrderAlreadyExistsException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/update/{id}")
    public Order getOrderById(@PathVariable Long id) throws OrderNotFoundException {
        return orderService.getOrderById(id);
    }

    @PostMapping("/update/{id}")
    public String updateOrder(@PathVariable Long id, @RequestBody Order order) throws OrderNotFoundException {
        try {
            orderService.updateOrder(order);
            return "The order was successfully updated";
        } catch (OrderNotFoundException | CustomerNotFoundException | ProductNotFoundException e) {
            return e.getMessage();
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable("id") Long id) {
        try {
            orderService.deleteOrder(id);
            return "Order deleted successfully";
        } catch (OrderNotFoundException e) {
            return "Failed to delete order: " + e.getMessage();
        }
    }
}
