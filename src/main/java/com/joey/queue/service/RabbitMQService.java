package com.joey.queue.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQService {

    @Value("${application.route.name}")
    private String route_name;

    @Value("${application.exchange.name}")
    private String exchange_name;

    // methods to send something to exchange
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage (String message) {
        if (message.contains("DQL")) throw new IllegalArgumentException("DQL test");
        rabbitTemplate.convertAndSend(exchange_name, route_name, message);
    }

}
