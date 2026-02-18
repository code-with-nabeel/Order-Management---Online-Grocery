package com.grocery.controller;

import com.grocery.model.GroceryItem;
import com.grocery.service.GroceryItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class GroceryItemController {

    private final GroceryItemService service;

    public GroceryItemController(GroceryItemService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<GroceryItem> create(@RequestBody GroceryItem item) {
        return new ResponseEntity<>(service.create(item), HttpStatus.CREATED);
    }

    @GetMapping
    public List<GroceryItem> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GroceryItem getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public GroceryItem update(@PathVariable Long id, @RequestBody GroceryItem item) {
        return service.update(id, item);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
