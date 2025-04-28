package com.example.demo.Controller;

import com.example.demo.Model.Customer;
import com.example.demo.Services.CustomerAlreadyExistsException;
import com.example.demo.Services.CustomerNotFoundException;
import com.example.demo.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("")
    public List<Customer> showCustomerList() {
        return service.listAll();
    }

    @PostMapping("/save")
    public String saveCustomer(@RequestBody Customer customer) throws CustomerAlreadyExistsException {
        try {
            service.save(customer);
            return "The customer has been saved successfully :)";
        } catch (CustomerAlreadyExistsException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/create")
    public Customer showNewForm() {
        return new Customer();
    }

    @GetMapping("/edit/{id}")
    public Customer showEditForm(@PathVariable("id") Long id) throws CustomerNotFoundException {
        return service.get(id);
    }

    @PostMapping("/edit/{id}")
    public String updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer) {
        try {
            service.updateCustomer(id, customer);
            return "The customer has been updated successfully :)";
        } catch (CustomerNotFoundException e) {
            return "Customer not found :(";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Long id) {
        try {
            service.delete(id);
            return "The customer with ID " + id + " has been deleted";
        } catch (CustomerNotFoundException e) {
            return e.getMessage();
        }
    }
}
