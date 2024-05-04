package com.example.mscustomer.service;

import com.example.mscustomer.model.entities.RegisteredCustomer;

import java.util.Optional;

public interface RegisteredCustomerService {
    RegisteredCustomer getById(Long id);

    void updateCustomerBalance(Long customerId, Float newBalance, String operation);
}
