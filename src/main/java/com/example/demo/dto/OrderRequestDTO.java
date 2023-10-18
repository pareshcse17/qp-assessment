package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_DEFAULT)
public class OrderRequestDTO {

	private String itemId;
	private Long count;
	
}
