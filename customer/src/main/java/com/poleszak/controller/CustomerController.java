package com.poleszak.controller;

import com.poleszak.entity.dto.CustomerRegistrationRequest;
import com.poleszak.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<HttpStatus> add(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        log.info("Customer registration {}", customerRegistrationRequest);
        customerService.addNewCustomer(customerRegistrationRequest);
        log.info("Customer successfully registered {}", customerRegistrationRequest);

        return ResponseEntity.ok(CREATED);
    }
}
