package com.poleszak.service;

import com.poleszak.entity.Customer;
import com.poleszak.entity.dto.CustomerRegistrationRequest;
import com.poleszak.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void addNewCustomer(CustomerRegistrationRequest registrationRequest) {
        Customer customer = Customer.builder()
                .firstname(registrationRequest.firstName())
                .lastname(registrationRequest.lastName())
                .email(registrationRequest.email())
                .build();

        customerRepository.save(customer);
    }
}
