package com.poleszak.notification;


import com.poleszak.notification.config.NotificationConfig;
import com.poleszak.rabbitmq.RabbitMQMessageProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
        scanBasePackages = {
                "com.poleszak.notification",
                "com.poleszak.rabbitmq"
        }
)
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer, NotificationConfig config) {
        return args -> {
            producer.publish("foo",
                    config.getInternalExchange(),
                    config.getInternalNotificationRoutingKey());
        };
    }
}
