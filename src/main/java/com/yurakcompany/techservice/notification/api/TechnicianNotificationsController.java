package com.yurakcompany.techservice.notification.api;

import com.yurakcompany.techservice.notification.domain.service.NotificationService;
import com.yurakcompany.techservice.notification.mapping.NotificationMapper;
import com.yurakcompany.techservice.notification.resource.CreateNotificationResource;
import com.yurakcompany.techservice.notification.resource.NotificationResource;
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
