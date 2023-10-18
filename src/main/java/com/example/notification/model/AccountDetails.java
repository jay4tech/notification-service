package com.example.notification.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDetails {

    private Long id;
    private Long name;
    private Double totalAmount;
    private String emailId;
    private String moibleNo;
    private String panCard;
    private String adharCard;

}
