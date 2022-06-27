package com.yurakcompany.techservice.subscription.mapping;

import com.yurakcompany.techservice.shared.mapping.EnhancedModelMapper;
import com.yurakcompany.techservice.subscription.domain.model.Subscription;
import com.yurakcompany.techservice.subscription.resource.CreateSubscriptionResource;
import com.yurakcompany.techservice.subscription.resource.SubscriptionResource;
import org.springframework.beans.factory.annotation.Autowired;

public class SubscriptionMapper {
    @Autowired
    EnhancedModelMapper mapper;
    public SubscriptionResource toResource(Subscription model) {return mapper.map(model, SubscriptionResource.class);}
    public Subscription toModel(CreateSubscriptionResource resource) {return mapper.map(resource, Subscription.class);}
}
