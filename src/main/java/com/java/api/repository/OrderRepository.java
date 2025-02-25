package com.java.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.java.api.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
