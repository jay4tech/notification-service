package com.example.notification.util;

import com.example.notification.model.Order;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;

@Configuration
public class RabbitHelper {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${queue.name.notification}")
    private String queueNotification;

    @Bean
    public Queue queueNotification() {
        return new Queue(queueNotification, true);
    }

    @RabbitListener(queues = {"${queue.name.notification}"})
    public void receiveEmailNotification(@Payload String message) {
        System.out.println("Message " + message);
        Order order = (Order) UtilityMapper.stringToModel(message, Order.class);
        EmailHelper.sendEmail(EmailHelper.prepareEmailDetails(order));
    }



}