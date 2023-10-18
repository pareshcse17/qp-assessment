package com.example.demo.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;


@Data
@JsonInclude(Include.NON_DEFAULT)
@Entity
@Table(name = "OrderDetail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private String id;
    
    @ManyToOne
    @JoinColumn(name = "InventoryID")
    private Inventory inventoryItem;
    
    @ManyToOne
    @JoinColumn(name = "OrderID")
    private Order order;
    
    @Column(name = "NumberOfItems")
    private Integer numberOfItems;
    
    // Constructors, getters, and setters
}
