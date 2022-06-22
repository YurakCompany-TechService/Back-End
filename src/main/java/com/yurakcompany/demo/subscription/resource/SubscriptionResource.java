package com.yurakcompany.demo.subscription.resource;

import com.yurakcompany.demo.security.register.resource.BusinessResource;
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
