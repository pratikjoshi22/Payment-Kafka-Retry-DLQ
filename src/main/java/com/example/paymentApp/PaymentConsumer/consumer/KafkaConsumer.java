package com.example.paymentApp.PaymentConsumer.consumer;

import com.example.paymentApp.PaymentConsumer.dto.UserEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "customer-payment", groupId = "payment-group")
    public void consumeUserEvent(UserEvent userEvent,
                                 @Header(KafkaHeaders.RECEIVED_KEY) String key){
        logger.info("Event Received with ID "+key );
        logger.info("Username {}, Address {}", userEvent.getName(), userEvent.getAddress());


    }
}
