package com.example.paymentApp.PaymentConsumer.Producer;


import com.example.paymentApp.PaymentConsumer.dto.UserEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {


    @Autowired
    private KafkaTemplate<String,UserEvent> kafkaTemplate;

    private static final Logger logger =LoggerFactory.getLogger(KafkaProducer.class);



    public void sendUserEvent(UserEvent userEvent) {

        if(userEvent != null){
            String key = userEvent.getId();
            logger.info("Sending Event with UserID: "+userEvent.getId());
            kafkaTemplate.send("customer-payment",key,userEvent);
            logger.info("Event sent with UserID: "+userEvent.getId());
        }
    }
}
