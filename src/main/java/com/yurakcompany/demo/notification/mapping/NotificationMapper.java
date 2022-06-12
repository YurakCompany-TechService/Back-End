package com.yurakcompany.demo.notification.mapping;

import com.yurakcompany.demo.notification.domain.model.Notification;
import com.yurakcompany.demo.notification.resource.CreateNotificationResource;
import com.yurakcompany.demo.notification.resource.NotificationResource;
import com.yurakcompany.demo.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class NotificationMapper {
    @Autowired
    EnhancedModelMapper mapper;
    public NotificationResource toResource(Notification model) { return mapper.map(model, NotificationResource.class); }
    public Notification toModel(CreateNotificationResource resource) { return mapper.map(resource, Notification.class);     }
}
