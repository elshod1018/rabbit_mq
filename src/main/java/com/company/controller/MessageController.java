package com.company.controller;

import com.company.dto.UserCreateDTO;
import com.company.producer.RabbitMQJsonProducer;
import com.company.producer.RabbitMQProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/message")
public class MessageController {
    private final RabbitMQProducer rabbitMQProducer;
    private final RabbitMQJsonProducer rabbitMQJsonProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam(name = "message") String message) {
        rabbitMQProducer.sendMessage(message);
        rabbitMQJsonProducer.sendJsonMessage(UserCreateDTO.builder()
                .id(1)
                .name(message)
                .email(message + "@gmail.com")
                .build());
        return ResponseEntity.ok("Message sent to the RabbitMQ ...");
    }
}
