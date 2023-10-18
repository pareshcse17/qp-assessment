package com.example.demo.dto;

import javax.persistence.Column;

import com.example.demo.domain.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_DEFAULT)
public class OrderResponseDto {

	private String itemName;
    private String itemDescription;
    private String itemType;
    private Long count;
    private Double marketPrice;
    
}
