package com.example.demo.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.time.LocalDate;

import lombok.Data;

@Data
@JsonInclude(Include.NON_DEFAULT)
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private String id;
    
    @Column(name = "OrderType")
    private String orderType;
    
    @Column(name = "OrderStatus")
    private String orderStatus;
    
    @ManyToOne
    @JoinColumn(name = "CustomerID")
    private Customer customer;
    
    @ManyToOne
    @JoinColumn(name = "DistributorID")
    private Distributor distributor;
    
    @Column(name = "OrderDate")
    private LocalDate orderDate;
    
    @Column(name = "TotalAmount")
    private Double totalAmount;
    
    @Column(name = "NumberOfItems")
    private Integer numberOfItems;
    
    // Constructors, getters, and setters
}

