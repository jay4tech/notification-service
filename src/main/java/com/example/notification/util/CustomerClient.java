package com.example.notification.util;

import com.example.notification.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "customer-service", url = "http://localhost:8081")
public interface CustomerClient {
  
    @PostMapping("/customers/")
    public Customer getCustomer(@PathVariable Long id);
  
}