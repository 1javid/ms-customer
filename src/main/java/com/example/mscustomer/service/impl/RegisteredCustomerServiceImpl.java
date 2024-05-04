package com.example.mscustomer.service.impl;

import com.example.mscustomer.model.entities.RegisteredCustomer;
import com.example.mscustomer.repository.RegisteredCustomerRepository;
import com.example.mscustomer.service.RegisteredCustomerService;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class RegisteredCustomerServiceImpl implements RegisteredCustomerService {
    private final RegisteredCustomerRepository registeredCustomerRepository;

    RegisteredCustomerServiceImpl(RegisteredCustomerRepository registeredCustomerRepository) {
        this.registeredCustomerRepository = registeredCustomerRepository;
    }

    @Override
    public RegisteredCustomer getById(Long id) {
        return registeredCustomerRepository.findById(id).get();
    }

    @Override
    public void updateCustomerBalance(Long customerId, Float newBalance, String operation) {
        RegisteredCustomer customer = registeredCustomerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        if(Objects.equals(operation, "+")) customer.setAccountBalance(customer.getAccountBalance() + newBalance);
        else if(Objects.equals(operation, "-")) customer.setAccountBalance(customer.getAccountBalance() - newBalance);
        registeredCustomerRepository.save(customer);
    }
}
