package com.example.notification.util;

import com.example.notification.client.AccountTransactionClient;
import com.example.notification.model.*;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageProcessor {

    @Autowired
    AccountTransactionClient accountTransactionClient;

    public boolean sendEmail(EmailDetails emailDetails) {
        // Send email and return the response;
        return true;
    }

    private boolean sendSMS(SMSDetails smsDetails) {
        // Send sms and return response
        return true;
    }

    public void processMessage(TransactionEvent transactionEvent) {
        AccountDetails accountDetails = accountTransactionClient.getAccountDetails(transactionEvent.getAccountNo());
        sendEmail(prepareEmail(transactionEvent, accountDetails));
        sendSMS(prepareSMS(transactionEvent,accountDetails));
    }

    private SMSDetails prepareSMS(TransactionEvent transactionEvent, AccountDetails accountDetails) {
        SMSDetails smsDetails = new SMSDetails();
        String smsBody = "Hey " + accountDetails.getName() + " your account has been";
        if (transactionEvent.getType().equals(TransactionType.CREDIT)) {
            smsBody += " credited by amount " + transactionEvent.getAmount();
            smsDetails.setSMSSubject("Account Credited!");
        }
        if (transactionEvent.getType().equals(TransactionType.DEBIT)) {
            smsBody += " debited amount " + transactionEvent.getAmount();
            smsDetails.setSMSSubject("Account Debited!");
        }
        smsDetails.setSMSBody(smsBody);
        return smsDetails;
    }

    public EmailDetails prepareEmail(TransactionEvent transactionEvent, AccountDetails accountDetails) {
        EmailDetails emailDetails = new EmailDetails();
        String emailBody = "Hey " + accountDetails.getName() + " your account has been";
        if (transactionEvent.getType().equals(TransactionType.CREDIT)) {
            emailBody += " credited by amount " + transactionEvent.getAmount();
            emailDetails.setEmailSubject("Account Credited!");
        }
        if (transactionEvent.getType().equals(TransactionType.DEBIT)) {
            emailBody += " debited amount " + transactionEvent.getAmount();
            emailDetails.setEmailSubject("Account Debited!");
        }
        emailDetails.setEmailBody(emailBody);
        return emailDetails;
    }

}
