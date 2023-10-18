package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import com.example.demo.repo.AdminRepository;
import com.example.demo.domain.AdminDetails;

@Service
public class AdminService {
	

    @Autowired
    private AdminRepository adminRepository;

    public AdminDetails login(String userId, String password) {
    	
        Optional<AdminDetails> adminOptional = adminRepository.findByUserIdIsAndPasswordIs(userId, password);

        // Check if an AdminDetails entity with the given credentials exists
        if (adminOptional.isPresent()) {
            return adminOptional.get(); // User is authenticated
        } else {
            return null; // User is not authenticated
        }
    }
}
