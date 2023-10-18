package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    // Custom query methods can be added here

    List<Inventory> findAll(); // Find all Inventory entities
    Optional<Inventory> findById(Long id); // Find an Inventory entity by ID
    Optional<Inventory> findByItemIsAndExpiredIs(Items item, String expired);
    Optional<List<Invertory>> findByDistributorIdIn(List<String> distriButorIds);
    Optional<List<Invertory>> findByItemIdIn(List<String> ItemIds);
    
}
