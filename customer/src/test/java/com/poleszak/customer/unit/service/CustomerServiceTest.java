package com.poleszak.customer.unit.service;

import com.poleszak.clients.fraud.FraudClient;
import com.poleszak.customer.entity.dto.CustomerRegistrationDto;
import com.poleszak.customer.repository.CustomerRepository;
import com.poleszak.customer.service.CustomerService;
import com.poleszak.rabbitmq.RabbitMQMessageProducer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private FraudClient fraudClient;
    @Mock
    private RabbitMQMessageProducer messageProducer;
    @InjectMocks
    private CustomerService customerService;

    @Test
    void addNewCustomer() {
        //given
        CustomerRegistrationDto customerRegistrationDto = new CustomerRegistrationDto("Flan", "Dzban", "flan@flan.com");

        //when
        customerService.addNewCustomer(customerRegistrationDto);
        //then
    }
}