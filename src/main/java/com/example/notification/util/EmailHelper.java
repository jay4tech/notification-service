package com.example.notification.util;

import com.example.notification.model.EmailDetails;
import com.example.notification.model.Order;

public class EmailHelper {

    public static boolean sendEmail(EmailDetails emailDetails){
        // Send email and return the response;
        return true;
    }

    public static EmailDetails prepareEmailDetails(Order order){
        EmailDetails emailDetails = new EmailDetails();
        emailDetails.setReceiverEmail(order.getEmail());
        // Modify the email body on requirement
        String emailBody = "Hey "+order.getProductId() +" payment is pending please proceed";
        emailDetails.setEmailSubject("Payment Details !");
        emailDetails.setEmailBody(emailBody);
        return emailDetails;
    }
}
