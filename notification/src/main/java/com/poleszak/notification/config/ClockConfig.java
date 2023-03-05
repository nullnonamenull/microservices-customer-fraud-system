package com.poleszak.notification.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import static java.time.Clock.*;

@Component
public class ClockConfig {

    @Bean
    public java.time.Clock clock() {
        return systemUTC();
    }
}
