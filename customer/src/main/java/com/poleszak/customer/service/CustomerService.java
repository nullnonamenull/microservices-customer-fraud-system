package com.poleszak.customer.service;

import com.poleszak.customer.entity.Customer;
import com.poleszak.customer.entity.dto.CustomerRegistrationDto;
import com.poleszak.customer.repository.CustomerRepository;
import com.poleszak.customer.response.FraudCheckResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public void addNewCustomer(CustomerRegistrationDto customerRegistrationDto) {
        Customer customer = Customer.builder()
                .firstname(customerRegistrationDto.firstName())
                .lastname(customerRegistrationDto.lastName())
                .email(customerRegistrationDto.email())
                .build();

        customerRepository.saveAndFlush(customer);
        checkFraudster(customer);
    }

    private void checkFraudster(Customer customer) {
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );

        if (fraudCheckResponse == null) {
            throw new NullPointerException("No response from fraud service for customer with id: " + customer.getId());
        }

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("Fraudster");
        }
    }
}
