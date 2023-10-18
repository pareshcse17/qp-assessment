package com.example.demo.web;


import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.*;

import com.example.demo.service.CustomerService;
import com.example.demo.service.ItemsService;
import com.example.demo.service.InventoryService;
import com.example.demo.exception.CustomException;
import com.example.demo.constants.ApplicationConstants;
import com.example.demo.domain.Items;


@Slf4j
@RestController
@RequestMapping("/customer-responsibilities")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired 
	private ItemsService itemsService;
	
	@Autowired
    private InventoryService inventoryService;
	
	// Retrieve admin responsibility by ID
    @GetMapping("/{itemType}")
    public ResponseEntity<Object> viewGroceryItems(@PathVariable String itemType, @RequestParam String mobile, @RequestParam String password) {
    	log.info("inside addNewGroceryItem");
    	ResponseDTO<List<Items>> response = new ResponseDTO();
    	response.setMetadata(new Metadata("1111", LocalDateTime.now()));
    	try {    		
    		
    		if(!customerService.login(mobile,password).isPresent()) return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseDTO((new Metadata("1111", LocalDateTime.now()), new CustomException(ApplicationConstants.ERROR_INVALID_CREDENTIALS)));
    		
    		if(!StringUtils.hasText(itemType)) return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseDTO(new Metadata("1111", LocalDateTime.now()), new CustomException(ApplicationConstants.ERROR_INVALID_INPUT)));
    		else {
    			List<Items> itemList = itemsService.findItemsByItemType(itemType);
    			response.setPayload(itemList);
    			return ResponseEntity.status(HttpStatus.OK)
        				.body(response);
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseDTO(new Metadata("1111", LocalDateTime.now()), new CustomException("1111", e.getMessage()))); 
    	}
    	return ResponseEntity.status(HttpStatus.OK)
				.body(response);

    }
    
    // method to book order
    @PostMapping("/bookOrder")
    public ResponseEntity<Object> bookOrder(@PathVariable String itemType, @RequestParam String mobile, @RequestParam String password, @RequestBody RequestDTO<Metadata, List<OrderRequestDTO>> OrderRequestDTO){
    	log.info("inside bookOrder");
    	ResponseDTO<List<OrderResponseDto>> response = new ResponseDTO();
    	response.setMetadata(new Metadata("1111", LocalDateTime.now()));
    	try {
    		Optional<Customer> customer = customerService.login(mobile,password);
    		if(!customer.isPresent()) return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseDTO((new Metadata("1111", LocalDateTime.now()), new CustomException(ApplicationConstants.ERROR_INVALID_CREDENTIALS)));
    		
    		if(null != orderRequestDTO || orderRequestDTO.getPayload().size() == 0)	return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseDTO(new Metadata("1111", LocalDateTime.now()), new CustomException(ApplicationConstants.ERROR_INVALID_INPUT)));
    		
    		else {
    			List<OrderResponseDto> orderItems = customerService.bookOrder(customer, orderRequestDTO.getPayload());
    			response.setPayload(orderItems);
    			return ResponseEntity.status(HttpStatus.OK)
        				.body(response);
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseDTO(new Metadata("1111", LocalDateTime.now()), new CustomException("1111", e.getMessage()))); 
    	}
    	return ResponseEntity.status(HttpStatus.OK)
				.body(response);
    	
    }


}
