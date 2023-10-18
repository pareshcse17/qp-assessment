package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

public interface ItemsRepository {

	@Repository
	public interface ItemsRepository extends JpaRepository<Items, Long> {
	    // Custom query methods can be added here

	    List<Items> findAll(); // Find all Items entities
	    Optional<Items> findById(Long id); // Find an Items entity by ID
	    Optional<List<Items>> findByItemType(String itemType); 
	    Optional<List<Items>> findByItemName(String itemName); 
	    
	    @Modifying
	    @Transactional
	    @Query("DELETE FROM Item i WHERE i.id = :itemId")
	    void deleteItem(String itemId);
	    
	  	}
	
}
