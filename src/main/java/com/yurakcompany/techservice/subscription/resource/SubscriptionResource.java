package com.yurakcompany.techservice.subscription.resource;

import com.yurakcompany.techservice.security.register.resource.BusinessResource;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionResource {
    private Long id;
    private String type;
    private BusinessResource businessResource;
}
