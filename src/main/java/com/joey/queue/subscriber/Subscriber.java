package com.joey.queue.subscriber;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "${application.queue.name}")
public class Subscriber {

    @Value("${application.queue.name}")
    private String queueName;

    @RabbitHandler
    public void consumer(@Payload String msg) {
        System.out.println("======================= Consumer Message =======================");
        System.out.println("Message: " + msg);
        System.out.println("From: " + queueName);
    }

}
