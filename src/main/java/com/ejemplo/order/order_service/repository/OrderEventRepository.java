package com.ejemplo.order.order_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejemplo.order.order_service.model.OrderEvent;

@Repository
public interface OrderEventRepository extends JpaRepository<OrderEvent, Long> {
}
