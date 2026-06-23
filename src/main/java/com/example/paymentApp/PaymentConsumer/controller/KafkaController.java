package com.example.paymentApp.PaymentConsumer.controller;


import com.example.paymentApp.PaymentConsumer.Producer.KafkaProducer;
import com.example.paymentApp.PaymentConsumer.dto.UserEvent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class KafkaController {

    private KafkaProducer kafkaProducer;

    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/sendMessage")
    public ResponseEntity<String> sendMessage(@RequestBody UserEvent userEvent)
    {
        kafkaProducer.sendUserEvent(userEvent);
        return ResponseEntity.ok("User Event sent!");
    }
}
