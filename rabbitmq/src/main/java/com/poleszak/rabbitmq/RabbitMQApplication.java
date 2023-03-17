package com.poleszak.rabbitmq;

import lombok.AllArgsConstructor;
import org.postgresql.core.ConnectionFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class RabbitMQApplication {

    private final ConnectionFactory connectionFactory;
}