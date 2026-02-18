package com.grocery.service;

import com.grocery.exception.ResourceNotFoundException;

import com.grocery.repository.CustomerRepository;
import com.grocery.repository.GroceryItemRepository;
import com.grocery.repository.OrderRepository;
import com.grocery.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepo;
    private final CustomerRepository customerRepo;
    private final GroceryItemRepository itemRepo;

    public OrderService(OrderRepository orderRepo,
                        CustomerRepository customerRepo,
                        GroceryItemRepository itemRepo) {
        this.orderRepo = orderRepo;
        this.customerRepo = customerRepo;
        this.itemRepo = itemRepo;
    }

    public Order create(Order order) {
        return orderRepo.save(order);
    }

    public List<Order> getAll() {
        return orderRepo.findAll();
    }

    public Order getById(Long id) {
        return orderRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
    }

    public void delete(Long id) {
        Order order = getById(id);
        orderRepo.delete(order);
    }
}

