package com.example.EmployeeManagementSystem.kafka.controller;

import com.example.EmployeeManagementSystem.kafka.service.KafkaProducerService;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducerService kafkaProducer;

    @PostMapping("/publish")
    public String publishMessage(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(message);
        return "Message sent to Kafka! " + message;
    }
}
