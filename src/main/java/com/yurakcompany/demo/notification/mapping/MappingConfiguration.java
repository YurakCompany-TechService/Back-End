package com.yurakcompany.demo.notification.mapping;

import com.yurakcompany.demo.notification.domain.model.Notification;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("notificationMappingConfiguration")
public class MappingConfiguration {
    @Bean
    NotificationMapper notificationMapper() { return new NotificationMapper(); }
}
