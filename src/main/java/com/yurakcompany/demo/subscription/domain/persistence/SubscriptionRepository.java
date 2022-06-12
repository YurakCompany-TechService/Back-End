package com.yurakcompany.demo.subscription.domain.persistence;

import com.yurakcompany.demo.subscription.domain.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    Subscription findByBusinessId (Long BusinessId);
}
