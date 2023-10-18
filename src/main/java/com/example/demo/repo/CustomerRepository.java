package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Custom query methods can be added here

    List<Customer> findAll(); // Find all Customer entities
    Optional<Customer> findById(Long id); // Find a Customer entity by ID
    Optional<Customer> findByMobileIsAndPasswordIs(String mobile, String password);
    
}
