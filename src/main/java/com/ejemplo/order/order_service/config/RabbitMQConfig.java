package com.ejemplo.order.order_service.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String QUEUE_NAME = "order_queue";

    @Bean
    public Queue orderQueue() {
        return new Queue(QUEUE_NAME, false);
    }
}
