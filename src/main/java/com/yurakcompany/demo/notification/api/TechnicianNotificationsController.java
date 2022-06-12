package com.yurakcompany.demo.notification.api;

import com.yurakcompany.demo.notification.domain.service.NotificationService;
import com.yurakcompany.demo.notification.mapping.NotificationMapper;
import com.yurakcompany.demo.notification.resource.CreateNotificationResource;
import com.yurakcompany.demo.notification.resource.NotificationResource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/technicians/{technicianId}/notifications")

public class TechnicianNotificationsController {

    private final NotificationService notificationService;
    private final NotificationMapper mapper;

    public TechnicianNotificationsController(NotificationService notificationService, NotificationMapper mapper) {
        this.notificationService = notificationService;
        this.mapper = mapper;
    }

    @PostMapping
    public NotificationResource createTechnicianNotification(@PathVariable Long technicianId,
                                                             @RequestBody CreateNotificationResource resource) {
        return mapper.toResource(notificationService.createTechnicianNotification(technicianId, mapper.toModel(resource)));
    }
}
