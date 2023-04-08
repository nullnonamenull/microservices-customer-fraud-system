package com.poleszak.customer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poleszak.customer.entity.dto.CustomerRegistrationDto;
import com.poleszak.customer.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CustomerService customerService;

    private CustomerRegistrationDto customerRegistrationDto;

    @BeforeEach
    public void setUp() {
        customerRegistrationDto = new CustomerRegistrationDto("Jan", "Kowalski", "jan.kowalski@example.com");
    }

    @Test
    public void shouldAddNewCustomer() throws Exception {
        mockMvc.perform(post("/api/v1/customer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerRegistrationDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName").value(customerRegistrationDto.firstName()))
                .andExpect(jsonPath("$.lastName").value(customerRegistrationDto.lastName()))
                .andExpect(jsonPath("$.email").value(customerRegistrationDto.email()))
                .andDo(print());
    }
}
