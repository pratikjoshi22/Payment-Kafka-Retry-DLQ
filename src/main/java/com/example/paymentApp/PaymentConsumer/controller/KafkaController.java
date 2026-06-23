package com.example.paymentApp.PaymentConsumer.controller;


import com.example.paymentApp.PaymentConsumer.Producer.KafkaProducer;
import com.example.paymentApp.PaymentConsumer.dto.UserEvent;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Kafka", description = "APIs to publish user events to Kafka")
public class KafkaController {


    private KafkaProducer kafkaProducer;
    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }
    @Operation(
            summary = "Send user event to Kafka",
            description = "Publishes a UserEvent message to the configured Kafka topic"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Event sent successfully",
            content = @Content(schema = @Schema(example = "User Event sent!"))
    )
    @PostMapping("/sendMessage")
    public ResponseEntity<String> sendMessage(@RequestBody UserEvent userEvent) {
        kafkaProducer.sendUserEvent(userEvent);
        return ResponseEntity.ok("User Event sent!");
    }
}
