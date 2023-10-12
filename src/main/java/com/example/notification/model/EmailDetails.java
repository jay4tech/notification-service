package com.example.notification.model;

import lombok.Data;

@Data
public class EmailDetails {
    private String emailSubject;
    private String receiverEmail;
    private String emailBody;
}
