package com.yurakcompany.techservice.notification.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("notificationMappingConfiguration")
public class MappingConfiguration {
    @Bean
    NotificationMapper notificationMapper() { return new NotificationMapper(); }
}
