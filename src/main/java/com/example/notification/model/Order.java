package com.example.notification.model;


import lombok.Data;


@Data
public class Order {
    private Long id;
    private Long productId;
    private Long quantity;
    private Long totalAmount;
    private String email;
}
