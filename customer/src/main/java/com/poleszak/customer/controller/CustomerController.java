package com.poleszak.customer.controller;

import com.poleszak.customer.entity.dto.CustomerRegistrationDto;
import com.poleszak.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerRegistrationDto> add(@RequestBody CustomerRegistrationDto customerRegistrationDto) {
        log.info("Customer registration {}", customerRegistrationDto);
        customerService.addNewCustomer(customerRegistrationDto);
        log.info("Customer successfully registered {}", customerRegistrationDto);

        return ResponseEntity.status(CREATED).body(customerRegistrationDto);
    }
}
