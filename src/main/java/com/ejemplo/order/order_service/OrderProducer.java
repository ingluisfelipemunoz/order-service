package com.ejemplo.order.order_service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.ejemplo.order.order_service.config.RabbitMQConfig;

@Service
public class OrderProducer {
    public final RabbitTemplate rabbitTemplate;

    public OrderProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendOrderMessage(String orderInfo) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, orderInfo);
        System.out.println("Order sent: " + orderInfo);
    }
}
