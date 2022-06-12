package com.yurakcompany.demo.notification.api;

import com.yurakcompany.demo.notification.domain.model.Notification;
import com.yurakcompany.demo.notification.domain.service.NotificationService;
import com.yurakcompany.demo.notification.mapping.NotificationMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notifications")
@CrossOrigin
public class NotificationsController {
    private final NotificationService notificationService;
    private final NotificationMapper mapper;

    public NotificationsController(NotificationService notificationService, NotificationMapper mapper) {
        this.notificationService = notificationService;
        this.mapper = mapper;
    }


    @GetMapping
    public List<Notification> getAll() {
        return notificationService.getAll();
    }
}
