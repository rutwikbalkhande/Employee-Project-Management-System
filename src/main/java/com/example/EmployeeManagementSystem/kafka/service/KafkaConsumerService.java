package com.example.EmployeeManagementSystem.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "demo-topic", groupId = "demo-group")
    public void consumer(String message) {
        System.out.println("Consumed message: " + message);
    }
}
