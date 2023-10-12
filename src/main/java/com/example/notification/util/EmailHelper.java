package com.example.notification.util;

import com.example.notification.model.Customer;
import com.example.notification.model.EmailDetails;
import com.example.notification.model.Reservation;

public class EmailHelper {

    public static boolean sendEmail(EmailDetails emailDetails){
        // Send email and return the response;
        return true;
    }

    public static EmailDetails prepareEmailDetails(Customer customerDetails){
        EmailDetails emailDetails = new EmailDetails();
        emailDetails.setReceiverEmail(customerDetails.getEmail());
        // Modify the email body on requirement
        String emailBody = "Hey "+customerDetails.getName() +" Happy to onboard you";
        emailDetails.setEmailSubject("Welcome onboard !");
        emailDetails.setEmailBody(emailBody);
        return emailDetails;
    }

    public static EmailDetails prepareEmailDetails(Reservation reservationDetails, Customer customerDetails){
        EmailDetails emailDetails = new EmailDetails();
        emailDetails.setReceiverEmail(customerDetails.getEmail());
        // Modify the email body on requirement
        String emailBody = "Hey "+customerDetails.getName() + " Here are your reservation details: "+ reservationDetails ;
        emailDetails.setEmailSubject("Reservation Details !");
        emailDetails.setEmailBody(emailBody);
        return emailDetails;
    }
}
