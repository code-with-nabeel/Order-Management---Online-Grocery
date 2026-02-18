package com.grocery.service;

import com.grocery.exception.ResourceNotFoundException;
import com.grocery.model.Customer;
import com.grocery.repository.CustomerRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {


    private CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    public Customer CreateCustomer(Customer c){
       return  repo.save(c);
    }

    public List<Customer> getAllUser() {
        List<Customer> customers= repo.findAll();
        if(customers.isEmpty()){
            throw new ResourceNotFoundException("No user Found in the databases");
        }
        return customers;
    }

    public Customer updateUser(Customer customer) {
        Optional<Customer> userOptional=repo.findById(customer.getId());
        Customer existing= userOptional.orElseThrow( ()->new IllegalArgumentException("User Whit ID "+ customer.getId()+" does not exist"));

        existing.setName(customer.getName());
        existing.setEmail(customer.getEmail());
        existing.setAddress(customer.getAddress());
        existing.setPhone(customer.getPhone());

        return repo.save(existing);
    }

    public Customer getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
    }

//    public Customer save(Customer c) {
//        return repo.save(c);
//    }

    public boolean deleteUser(Long id) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("User with ID " + id + " does not exist");
        }
        repo.deleteById(id);
        return true;
    }
}

