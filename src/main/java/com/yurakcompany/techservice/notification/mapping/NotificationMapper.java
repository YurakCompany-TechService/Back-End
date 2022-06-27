package com.yurakcompany.techservice.notification.mapping;

import com.yurakcompany.techservice.notification.domain.model.Notification;
import com.yurakcompany.techservice.notification.resource.CreateNotificationResource;
import com.yurakcompany.techservice.notification.resource.NotificationResource;
import com.yurakcompany.techservice.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class NotificationMapper {
    @Autowired
    EnhancedModelMapper mapper;
    public NotificationResource toResource(Notification model) { return mapper.map(model, NotificationResource.class); }
    public Notification toModel(CreateNotificationResource resource) { return mapper.map(resource, Notification.class);     }
}
