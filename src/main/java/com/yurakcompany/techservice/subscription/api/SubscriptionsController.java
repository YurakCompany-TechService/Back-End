package com.yurakcompany.techservice.subscription.api;

import com.yurakcompany.techservice.subscription.domain.service.SubscriptionService;
import com.yurakcompany.techservice.subscription.mapping.SubscriptionMapper;
import com.yurakcompany.techservice.subscription.resource.SubscriptionResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/subscriptions")
public class SubscriptionsController {

    private final SubscriptionService subscriptionService;
    private final SubscriptionMapper mapper;

    public SubscriptionsController(SubscriptionService subscriptionService, SubscriptionMapper mapper) {
        this.subscriptionService = subscriptionService;
        this.mapper = mapper;
    }

    @GetMapping("{subscriptionId}")
    public SubscriptionResource getById(@PathVariable Long subscriptionId) {
        return mapper.toResource(subscriptionService.getById(subscriptionId));
    }
}
