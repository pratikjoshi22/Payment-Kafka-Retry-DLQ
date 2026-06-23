package com.example.paymentApp.PaymentConsumer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic myTopic(){

        // 1. Automatically creates the topic in KRaft on startup
        return TopicBuilder.name("customer-payment")
                .partitions(1)
                .replicas(1)
                .build();
    }

}
