package com.example.notification.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Customer {
    private Long id;
    private String name;
    private String email;
    private String password;
}