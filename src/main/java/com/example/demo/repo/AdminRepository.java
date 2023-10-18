package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<AdminDetails, String> {
    // Custom query methods can be added here

    List<AdminDetails> findAll(); // Find all Admin entities
    Optional<AdminDetails> findByUserIdIsAndPasswordIs(String userId, String password);
    
}
