package com.example.demo.repo;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    // Custom query methods can be added here

    List<OrderDetail> findAll(); // Find all OrderDetail entities
    Optional<OrderDetail> findById(String id); // Find an OrderDetail entity by ID
    Optional<OrderDetail> findByOrderId(String orderId);
    Optional<OrderDetail> findByItemId(String ItemId);
}
