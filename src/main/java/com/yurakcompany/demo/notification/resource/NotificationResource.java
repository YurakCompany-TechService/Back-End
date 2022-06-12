package com.yurakcompany.demo.notification.resource;

import com.yurakcompany.demo.register.resource.BusinessResource;
import com.yurakcompany.demo.register.resource.TechnicianResource;
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
