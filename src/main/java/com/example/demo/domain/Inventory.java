package com.example.demo.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.time.LocalDate;

import lombok.Data;

@Data
@JsonInclude(Include.NON_DEFAULT)
@Entity
@Table(name = "Inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private String id;
    
    @ManyToOne
    @JoinColumn(name = "ItemID")
    private Items item;
    
    @Column(name = "QuantityInStock")
    private Integer quantityInStock;
    
    @Column(name = "MarketPrice")
    private Double marketPrice;
    
    @Column(name = "SellingPrice")
    private Double sellingPrice;
    
    @Column(name = "CostPrice")
    private Double costPrice;
    
    @Column(name = "Expired")
    private String expired;		//Y N
    
    @Column(name = "StockInDate")
    private LocalDate stockInDate;
    
    @Column(name = "StockEndDate")
    private LocalDate stockEndDate;
    
    @OneToMany
    @JoinColumn(name = "DistributorID")
    private Distributor distributor;
      

    // Constructors, getters, and setters
}
