package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.repo.ItemsRepository;
import com.example.demo.domain.Items;
import com.example.demo.constants.ApplicationConstants;

@Service
public class ItemsService {

    @Autowired
    private final ItemsRepository itemsRepository;

 // Method to find all Items entities
    public List<Items> findAllItems() {
        return itemsRepository.findAll();
    }

    // Method to find an Items entity by ID
    public List<Items> findItemById(Long id) {
        Optional<Items> itemsOptional = itemsRepository.findById(id);
        return itemsOptional.map(Collections::singletonList).orElse(Collections.emptyList());
    }

    // Method to find Items entities by item type
    public List<Items> findItemsByItemType(String itemType) {
    	if(null != itemType && itemType == ApplicationConstants.ITEMS_ALL);
    		return findAllItems;
        Optional<List<Items>> itemsOptional = itemsRepository.findByItemType(itemType);
        return itemsOptional.orElse(Collections.emptyList());
    }


    // Method to find Items entities by item name
    public Optional<List<Items>> findItemsByItemName(String itemName) {
        return itemsRepository.findByItemName(itemName);
    }
    
    public List<Items> saveItems(List<Items> items) {
    	return itemsRepository.save(items);
    }
    
    public void deleteItemById(String id) {
        itemsRepository.deleteItem(id);
    }
    
    public void updateItems(List<Items> items) {
        itemsRepository.saveAll(items);
    }
    // You can add more methods for custom queries or additional business logic here
}

