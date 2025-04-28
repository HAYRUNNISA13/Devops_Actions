package com.example.demo.Controller;

import com.example.demo.Model.Product;
import com.example.demo.Services.ProductAlreadyExistsException;
import com.example.demo.Services.ProductNotFoundException;
import com.example.demo.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public List<Product> showProductList() {
        return productService.listAll();
    }

    @PostMapping("/save")
    public String saveProduct(@RequestBody Product product) throws ProductAlreadyExistsException {
        try {
            productService.save(product);
            return "The product has been saved successfully :)";
        } catch (ProductAlreadyExistsException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/create")
    public Product showNewForm() {
        return new Product();
    }

    @GetMapping("/edit/{id}")
    public Product showEditForm(@PathVariable("id") Long id) throws ProductNotFoundException {
        return productService.get(id);
    }

    @PostMapping("/edit/{id}")
    public String updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        try {
            productService.updateProduct(id, product);
            return "The product has been updated successfully :)";
        } catch (ProductNotFoundException e) {
            return "Product not found :(";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        try {
            productService.delete(id);
            return "Product with ID " + id + " has been deleted";
        } catch (ProductNotFoundException e) {
            return e.getMessage();
        }
    }
}
