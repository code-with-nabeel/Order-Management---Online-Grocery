package com.grocery.service;

import com.grocery.exception.ResourceNotFoundException;
import com.grocery.model.GroceryItem;
import com.grocery.repository.GroceryItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryItemService {

    private final GroceryItemRepository repo;

    public GroceryItemService(GroceryItemRepository repo) {
        this.repo = repo;
    }

    public GroceryItem create(GroceryItem item) {
        return repo.save(item);
    }

    public List<GroceryItem> getAll() {
        return repo.findAll();
    }

    public GroceryItem getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found"));
    }

    public GroceryItem update(Long id, GroceryItem updated) {
        GroceryItem existing = getById(id);

        existing.setName(updated.getName());
        existing.setCategory(updated.getCategory());
        existing.setPrice(updated.getPrice());
        existing.setQuantity(updated.getQuantity());

        return repo.save(existing);
    }

    public void delete(Long id) {
        GroceryItem item = getById(id);
        repo.delete(item);
    }
}

