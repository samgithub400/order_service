package com.ios.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ios.orderservice.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
