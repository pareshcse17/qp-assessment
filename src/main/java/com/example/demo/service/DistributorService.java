package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.repo.DistributorRepository;
import com.example.demo.domain.Distributor;

@Service
public class DistributorService {
    

    @Autowired
    private DistributorRepository distributorRepository;

    // Method to find all Distributor entities
    public List<Distributor> findAllDistributors() {
        return distributorRepository.findAll();
    }

    // Method to find a Distributor entity by ID
    public Optional<Distributor> findDistributorById(Long id) {
        return distributorRepository.findById(id);
    }

    // Method to find a Distributor entity by GST number
    public Optional<Distributor> findByGstNumber(String gstNumber) {
        return distributorRepository.findByGstNumber(gstNumber);
    }

    // Method to find a Distributor entity by phone number
    public Optional<Distributor> findByPhone(String phone) {
        return distributorRepository.findByPhone(phone);
    }
    
    // You can add more methods for custom queries or additional business logic here
}

