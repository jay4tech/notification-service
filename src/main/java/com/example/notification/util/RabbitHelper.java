package com.example.notification.util;

import com.example.notification.model.Customer;
import com.example.notification.model.EmailDetails;
import com.example.notification.model.Reservation;
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
    CustomerClient customerClient;
    @Value("${queue.name.email}")
    private String emailQueue;
    @Value("${queue.name.reservation}")
    private String reservationQueue;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Bean
    public Queue emailQueue() {
        return new Queue(emailQueue, true);
    }

    @Bean
    public Queue reservationQueue() {
        return new Queue(reservationQueue, true);
    }

    @RabbitListener(queues = {"${queue.name.email}"})
    public void receiveEmailNotification(@Payload String message) {
        System.out.println("Message " + message);
        Customer customerDetails = (Customer) UtilityMapper.stringToModel(message, Customer.class);
        EmailHelper.sendEmail(EmailHelper.prepareEmailDetails(customerDetails));
    }

    @RabbitListener(queues = {"${queue.name.reservation}"})
    public void receiveReservationNotification(@Payload String message) {
        System.out.println("Message " + message);
        Reservation reservationDetails = (Reservation) UtilityMapper.stringToModel(message, Reservation.class);
        Customer customer = customerClient.getCustomer(reservationDetails.getCustomerId());
        EmailHelper.sendEmail(EmailHelper.prepareEmailDetails(reservationDetails, customer));
    }

}