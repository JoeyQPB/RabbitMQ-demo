package com.joey.queue.publisher;

import com.joey.queue.service.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class PublisherController {

    @Autowired
    private RabbitMQService rabbitMQService;

    @PostMapping
    public void sendMessage(@RequestBody String message) {
        System.out.println("======================= Send Message =======================");
        rabbitMQService.sendMessage(message);
    }
}
