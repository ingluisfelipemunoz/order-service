package com.ejemplo.order.order_service.service;

import java.time.LocalDateTime;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.ejemplo.order.order_service.config.RabbitMQConfig;
import com.ejemplo.order.order_service.model.OrderEvent;
import com.ejemplo.order.order_service.repository.OrderEventRepository;

@Service
public class OrderConsumer {
    private final OrderEventRepository orderEventRepository;

    public OrderConsumer(OrderEventRepository orderEventRepository) {
        this.orderEventRepository = orderEventRepository;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receiveOrderMessage(String orderInfo) {
        System.out.println("Order received: " + orderInfo);
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setOrderInfo(orderInfo);
        orderEvent.setCreatedAt(LocalDateTime.now());
        orderEventRepository.save(orderEvent);
        System.out.println("Order saved: " + orderEvent);
    }
}
