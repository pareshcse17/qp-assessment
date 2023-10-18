package com.example.demo.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_DEFAULT)
@Entity
@Table(name = "Distributor")
public class Distributor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private String id;
    
    @Column(name = "RegisteredName")
    private String registeredName;
    
    @Column(name = "Address")
    private String address;
    
    @Column(name = "GSTNumber")
    private String gstNumber;
    
    @Column(name = "Phone")
    private String phone;
    
    @Column(name = "Email")
    private String email;
    
    // Constructors, getters, and setters
}
