package com.ejemplo.order.order_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.order.order_service.OrderProducer;
import com.ejemplo.order.order_service.dto.OrderEventDto;

@RestController
public class OrderController {
    private final OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendOrder(@RequestBody OrderEventDto orderInfo) {
        orderProducer.sendOrderMessage(orderInfo.getOrderInfo());
        return ResponseEntity.ok("Order message sent");
    }
}
