package com.yurakcompany.techservice.notification.resource;

import com.yurakcompany.techservice.security.register.resource.TechnicianResource;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class NotificationResource {
    private Long id;

    private String description;
    private String title;

    private TechnicianResource technician;
   // private BusinessResource business;
}
