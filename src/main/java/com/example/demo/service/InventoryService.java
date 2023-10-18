package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.repo.InventoryRepository;
import com.example.demo.domain.Inventory;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    // Method to find all Inventory entities
    public List<Inventory> findAllInventories() {
        return inventoryRepository.findAll();
    }

 // Method to find an Inventory entity by ID
    public List<Inventory> findInventoryById(Long id) {
        Optional<Inventory> inventoryOptional = inventoryRepository.findById(id);
        return inventoryOptional.orElse(Collections.emptyList());
    }

    // Method to find Inventory entities by a list of distributor IDs
    public List<Inventory> findByDistributorIds(List<String> distributorIds) {
        Optional<List<Inventory>> inventoryOptional = inventoryRepository.findByDistributorIdIn(distributorIds);
        return inventoryOptional.orElse(Collections.emptyList());
    }

    // Method to find Inventory entities by a list of item IDs
    public List<Inventory> findByItemIds(List<String> itemIds) {
        Optional<List<Inventory>> inventoryOptional = inventoryRepository.findByItemIdIn(itemIds);
        return inventoryOptional.orElse(Collections.emptyList());
    }
    
    public List<Inventory> updateInventory(List<Inventory> inventory) {
        return inventoryRepository.saveAll(inventory);
    }
    
    // You can add more methods for custom queries or additional business logic here
}

