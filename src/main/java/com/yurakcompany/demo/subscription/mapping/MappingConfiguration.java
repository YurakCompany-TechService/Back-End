package com.yurakcompany.demo.subscription.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("subscriptionMappingConfiguration")
public class MappingConfiguration {
    @Bean
    SubscriptionMapper subscriptionMapper() { return new SubscriptionMapper(); }
}
