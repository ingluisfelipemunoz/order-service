package com.ejemplo.order.order_service.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.ejemplo.order.order_service.config.RabbitMQConfig;

@Service
public class OrderConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receiveOrderMessage(String orderInfo) {
        System.out.println("Order received: " + orderInfo);
    }
}
