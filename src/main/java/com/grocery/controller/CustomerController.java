package com.grocery.controller;

import com.grocery.model.Customer;
import com.grocery.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService service) {
        this.customerService = service;
    }

    @PostMapping
    public ResponseEntity<Customer> createUser(@RequestBody Customer customer){
        Customer createdUser = customerService.CreateCustomer(customer);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateUser(
            @PathVariable Long id,
            @RequestBody Customer customer){

        customer.setId(id);
        Customer updated = customerService.updateUser(customer);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        customerService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<Customer> getUser(){
        return customerService.getAllUser();
    }

    @GetMapping("/{id}")
    public Customer get(@PathVariable Long id) {
        return customerService.getById(id);
    }
}
