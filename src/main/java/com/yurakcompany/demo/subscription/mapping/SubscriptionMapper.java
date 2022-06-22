package com.yurakcompany.demo.subscription.mapping;

import com.yurakcompany.demo.shared.mapping.EnhancedModelMapper;
import com.yurakcompany.demo.subscription.domain.model.Subscription;
import com.yurakcompany.demo.subscription.resource.CreateSubscriptionResource;
import com.yurakcompany.demo.subscription.resource.SubscriptionResource;
import org.springframework.beans.factory.annotation.Autowired;

public class SubscriptionMapper {
    @Autowired
    EnhancedModelMapper mapper;
    public SubscriptionResource toResource(Subscription model) {return mapper.map(model, SubscriptionResource.class);}
    public Subscription toModel(CreateSubscriptionResource resource) {return mapper.map(resource, Subscription.class);}
}
