package com.yurakcompany.demo.notification.resource;

import com.yurakcompany.demo.security.register.resource.BusinessResource;
import com.yurakcompany.demo.security.register.resource.TechnicianResource;
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
