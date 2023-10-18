package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.repo.CustomerRepository;
import com.example.demo.domain.Inventory;
import com.example.demo.repo.InventoryRepository;
import com.example.demo.repo.ItemsRepository;
import com.example.demo.repo.OrderRepository;
import com.example.demo.repo.OrderDetailRepository;
import com.example.demo.repo.Long;
import com.example.demo.repo.String;
import com.example.demo.dto.OrderRequestDTO;
import com.example.demo.exception.CustomException;
import com.example.demo.constants.ApplicationConstants;
import com.example.demo.domain.Customer;
import com.example.demo.domain.Order;
import com.example.demo.domain.OrderDetail;

@Service
public class CustomerService {
	

    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private InventoryRepository inventoryRepository;
    
    @Autowired
    private ItemsRepository itemsRepository;
    
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private OrderDetailRepository OrderDetailRepository;
    
    // Method to find all Customer entities
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    // Method to find a Customer entity by ID
    public Optional<Customer> findCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    // Method to authenticate a Customer by mobile and password
    public Optional<Customer> login(String mobile, String password) {
    	Optional<Customer> customer = customerRepository.findByMobileIsAndPasswordIs(mobile, password);
    	 if (customer.isPresent()) {
             return customer.get(); // User is authenticated
         } else {
             return null; // User is not authenticated
         }
    }
    
    //Method to book an order
    public List<OrderResponseDto> bookOrder(List<OrderRequestDTO>> orders, Customer customer) {
    	List<OrderResponseDto> response = new ArrayList<>(); 
    	List<OrderDetail> orderDetails = new ArrayList<>();
    	Double totalCost = new Double();
		Order order = new Order();
		
    	for(OrderRequestDTO orderBook : orders) {
    		OrderResponseDto orderResponseDto = new OrderResponseDto();
    		OrderDetail orderDetail;
    		Optional<Items> item = itemsRepository.findById(orderBook.getIte);
    		if(item.isPresent()) {
        		Optional<Inventory> inventory = inventoryRepository.findByItemIsAndExpiredIs(item.getItemId()), String expired);
        		if(!inventory.isPresent()) throw new CustomException(ApplicationConstants.INVENTORY_OUT_OF_STOCK);
    			orderDetail = createOrderDetail(inventory.get(), order, orderBook.getCount());
    			orderDetails.add(orderDetail);
    			inventory.setQuantityInStock(inventory.getQuantityInStock()-orderBook.getCount());
    			itemsRepository.save(Inventory);
    			orderResponseDto.setItemName(item.get().getItemName);
    			orderResponseDto.setItemType(item.get().getItemType);
    			orderResponseDto.setItemDescription(item.get().getItemDescription);
    			orderResponseDto.setCount(orderBook.getCount());
    			orderResponseDto.setMarketPrice(inventory.getMarketPrice());
    			totalCost= totalCost + orderResponseDto.getMarketPrice();
    			response.add(orderResponseDto);
        		
    		}
    	}
    	
    	order.setOrderType(ApplicationConstants.ORDER_TYPE_CUSTOMER_SELL);
		order.setCustomer(Customer);
		order.setOrderDate(LocalDateTime.now().getDate());
		order.setTotalAmount(totalCost);
		order.NumberOfItems(orderDetails.size());
		OrderDetailRepository.saveAll(orderDetails);
		OrderRepository.save(order);
		
		return response;
		
    	
    }
    
    private OrderDetail createOrderDetail(Inventory inventory, Order order, Long count) {
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setInventory(inventory);
		orderDetail.setOrder(order);
		orderDetail.setNumberOfItems(count);
		return orderDetail;
		
		
    }
}

