package com.poleszak.customer.service;

import com.poleszak.customer.entity.Customer;
import com.poleszak.customer.entity.dto.CustomerRegistrationDto;
import com.poleszak.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void addNewCustomer(CustomerRegistrationDto customerRegistrationDto) {
        Customer customer = Customer.builder()
                .firstname(customerRegistrationDto.firstName())
                .lastname(customerRegistrationDto.lastName())
                .email(customerRegistrationDto.email())
                .build();

        customerRepository.save(customer);
    }
}
