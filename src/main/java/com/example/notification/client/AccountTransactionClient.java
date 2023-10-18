package com.example.notification.client;

import com.example.notification.model.AccountDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "account-management", url = "http://localhost:8888/accounts")
public interface AccountTransactionClient {

    @GetMapping("/{id}")
    AccountDetails getAccountDetails(@PathVariable Long id);
  
}