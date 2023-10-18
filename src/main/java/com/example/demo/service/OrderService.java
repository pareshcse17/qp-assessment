package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;


import com.example.demo.repo.OrderRepository;
import com.example.demo.domain.OrderDetail;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Method to find all Order entities
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    // Method to find an Order entity by ID
    public List<Order> findOrderById(Long id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        return orderOptional.map(Collections::singletonList).orElse(Collections.emptyList());
    }

    // Method to find orders by customer ID
    public List<Order> findOrdersByCustomerId(String customerId) {
        Optional<List<Order>> orderOptional = orderRepository.findByCustomerId(customerId);
        return orderOptional.orElse(Collections.emptyList());
    }

    // Method to find orders by distributor ID
    public List<Order> findOrdersByDistributorId(String distributorId) {
        Optional<List<Order>> orderOptional = orderRepository.findByDistributorId(distributorId);
        return orderOptional.orElse(Collections.emptyList());
    }

    // Method to find orders by order date
    public List<Order> findOrdersByOrderDate(LocalDate date) {
        Optional<List<Order>> orderOptional = orderRepository.findByOrderDate(date);
        return orderOptional.orElse(Collections.emptyList());
    }
    
    // You can add more methods for custom queries or additional business logic here
}

