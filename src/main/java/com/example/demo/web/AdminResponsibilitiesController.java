package com.example.demo.web;

import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.*;

import com.example.demo.service.AdminService;
import com.example.demo.service.ItemsService;
import com.example.demo.service.InventoryService;
import com.example.demo.exception.CustomException;
import com.example.demo.constants.ApplicationConstants;
import com.example.demo.domain.Items;


@Slf4j
@RestController
@RequestMapping("/admin-responsibilities")
public class AdminResponsibilityController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired 
	private ItemsService itemsService;
	
	@Autowired
    private InventoryService inventoryService;


    // Retrieve admin responsibility by ID
    @GetMapping("/{itemType}")
    public ResponseEntity<Object> viewGroceryItems(@PathVariable String itemType, @RequestParam String adminId, @RequestParam String password) {
    	log.info("inside addNewGroceryItem");
    	ResponseDTO<List<Items>> response = new ResponseDTO();
    	response.setMetadata(new Metadata("1111", LocalDateTime.now()));
    	try {    		
    		
    		if(!adminService.login(adminId,password).isPresent()) return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseDTO(new Metadata("1111", LocalDateTime.now()), new CustomException(ApplicationConstants.ERROR_INVALID_CREDENTIALS)));
    		
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
    	return return ResponseEntity.status(HttpStatus.OK)
				.body(response);

    }

    // save new grocery items
    @PostMapping("/addNewGroceryItem")
    public ResponseEntity<Object> addNewGroceryItem(@RequestParam String adminId, @RequestParam String password, @RequestBody RequestDTO<Metadata, List<Items>> items) {
    	log.info("inside addNewGroceryItem");
    	ResponseDTO<List<Items>> response = new ResponseDTO();
    	try {    		
    		
    		if(!adminService.login(adminId,password).isPresent()) return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseDTO(items.getMetadata, new CustomException(ApplicationConstants.ERROR_INVALID_CREDENTIALS)));
    		
    		if(null == items || items.size() == 0) return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseDTO(items.getMetadata, new CustomException(ApplicationConstants.ERROR_INVALID_INPUT)));
    		else {
    			List<Items> savedItems = itemsService.saveItems(items.getPayload());
    			response.setPayload(savedItems);
    			return ResponseEntity.status(HttpStatus.OK)
        				.body(response);
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseDTO(items.getMetadata, new CustomException("1111", e.getMessage()))); 
    	}
    	return return ResponseEntity.status(HttpStatus.OK)
				.body(response);
    }

    // Update an existing Items
    @PutMapping("/updateItems")
    public ResponseEntity<Object> updateItems(@RequestParam String adminId, @RequestParam String password, @RequestBody RequestDTO<Metadata, List<Items>> items) {
    	log.info("inside addNewGroceryItem");
    	ResponseDTO<List<Items>> response = new ResponseDTO();
    	try {    
    		
    		if(!adminService.login(adminId,password).isPresent()) return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseDTO(new Metadata("1111", LocalDateTime.now()), new CustomException(ApplicationConstants.ERROR_INVALID_CREDENTIALS)));
    		
    		if(null != items && items.size() == 0) return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseDTO(new Metadata("1111", LocalDateTime.now()), new CustomException(ApplicationConstants.ERROR_INVALID_INPUT)));
    		else {
    			itemService.updateItems(items.getPayload());
    			response.setPayload("Item Updated");
    			return ResponseEntity.status(HttpStatus.OK)
        				.body(response);
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseDTO(new Metadata("1111", LocalDateTime.now()), new CustomException("1111", e.getMessage()))); 
    	}
    	return return ResponseEntity.status(HttpStatus.OK)
				.body(response);
    }

    // Delete an Item
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteItem(@PathVariable Long id, @RequestParam String adminId, @RequestParam String password) {
    	log.info("inside addNewGroceryItem");
    	ResponseDTO<String> response = new ResponseDTO();
    	response.setMetadata("1111", LocalDateTime.now());
    	try {   
    		if(!adminService.login(adminId,password).isPresent()) return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseDTO(new Metadata("1111", LocalDateTime.now()), new CustomException(ApplicationConstants.ERROR_INVALID_CREDENTIALS)));
    		
    		
    		if(null == id) return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseDTO(items.getMetadata, new CustomException(ApplicationConstants.ERROR_INVALID_INPUT)));
    		else {
    			Items deletedItem = itemsService.deleteItemById(id);
    			response.setPayload("Item Deleted");
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
    
    
    // Manage Inventory
    @PutMapping("/manageInventory")
    public ResponseEntity<String> updateInventory(@RequestParam String adminId, @RequestParam String password, @RequestBody RequestDTO<Metadata, List<Inventory> inventory) {
        inventoryService.updateInventory(inventory);
        return ResponseEntity.ok("Inventory updated successfully");
        log.info("inside manageInventory");
    	ResponseDTO<String> response = new ResponseDTO();
    	response.setMetadata("1111", LocalDateTime.now());
    	try {   
    		if(!adminService.login(adminId,password).isPresent()) return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseDTO(new Metadata("1111", LocalDateTime.now()), new CustomException(ApplicationConstants.ERROR_INVALID_CREDENTIALS)));
    		
    		
    		if(null != inventory && inventory.size() == 0) return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ResponseDTO(items.getMetadata, new CustomException(ApplicationConstants.ERROR_INVALID_INPUT)));
    		else {
    			List<Inventory> updatedInventory = inventoryService.updateInventory(inventory);
    			response.setPayload("Inventory Updated");
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

