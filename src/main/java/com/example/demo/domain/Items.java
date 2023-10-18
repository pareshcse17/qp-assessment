package com.example.demo.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_DEFAULT)
@Entity
@Table(name = "Items")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private String id;
    
    @Column(name = "ItemName")
    private String itemName;
    
    @Column(name = "ItemDescription")
    private String itemDescription;
    
    @Column(name = "ItemType")
    private String itemType;
    
    // Constructors, getters, and setters
}

