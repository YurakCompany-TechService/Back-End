package com.yurakcompany.demo.subscription.api;

import com.yurakcompany.demo.subscription.domain.service.SubscriptionService;
import com.yurakcompany.demo.subscription.mapping.SubscriptionMapper;
import com.yurakcompany.demo.subscription.resource.CreateSubscriptionResource;
import com.yurakcompany.demo.subscription.resource.SubscriptionResource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/business/{businessId}/subscriptions")
public class BusinessSubscriptionsController {
    private final SubscriptionService subscriptionService;
    private final SubscriptionMapper mapper;

    public BusinessSubscriptionsController(SubscriptionService subscriptionService, SubscriptionMapper mapper) {
        this.subscriptionService = subscriptionService;
        this.mapper = mapper;
    }

    @PostMapping
    public SubscriptionResource create(@PathVariable Long businessId, @RequestBody CreateSubscriptionResource resource) {
        return mapper.toResource(subscriptionService.create(businessId, mapper.toModel(resource)));
    }
}
