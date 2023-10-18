package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Custom query methods can be added here

    List<Order> findAll(); // Find all Order entities
    Optional<Order> findById(String id); // Find an Order entity by ID
    Optional<List<Order>> findByCustomerId(String customerId);
    Optional<List<Order>> findByDistributorId(String distributorId);
    Optional<List<Order>> findByOrderDate(LocalDate date);
}
