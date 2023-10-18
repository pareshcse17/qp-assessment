package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface DistributorRepository extends JpaRepository<Distributor, Long> {
    // Custom query methods can be added here

    List<Distributor> findAll(); // Find all Distributor entities
    Optional<Distributor> findById(Long id); // Find a Distributor entity by ID
    Optional<Distributor> findByGstNumber(String gstNumber);
    Optional<Distributor> findByPhone(String phone);
    
}
