package com.example.demo.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_DEFAULT)
@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private String id;
    
    @Column(name = "Name")
    private String name;
    
    @Column(name = "Mobile")
    private String mobile;
    
    @Column(name = "Password")
    private String password;
    
    @Column(name = "OrderCount")
    private Integer orderCount;
    
    // Constructors, getters, and setters @Data lombok
}

