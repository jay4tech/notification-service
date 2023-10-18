package com.example.notification.util;

import com.example.notification.model.TransactionEvent;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;

@Configuration
public class MessageConsumer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${queue.name.notification}")
    private String queueNotification;

    @Autowired
    MessageProcessor messageProcessor;

    @Bean
    public Queue queueNotification() {
        return new Queue(queueNotification, true);
    }

    @RabbitListener(queues = {"${queue.name.debitCredit}"})
    public void receiveDebitCredit(@Payload String message) {
        try {
            System.out.println("Message " + message);
            TransactionEvent transactionEvent = (TransactionEvent) UtilityMapper.stringToModel(message, TransactionEvent.class);
            messageProcessor.processMessage(transactionEvent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}