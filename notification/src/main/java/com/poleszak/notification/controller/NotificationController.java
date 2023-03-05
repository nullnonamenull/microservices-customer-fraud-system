package com.poleszak.notification.controller;

import com.poleszak.clients.notification.NotificationRequest;
import com.poleszak.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/notification")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
        log.info("Sending new notification {}", notificationRequest);
        notificationService.createNotification(notificationRequest);
        log.info("New notification send: {}", notificationRequest);
    }
}
