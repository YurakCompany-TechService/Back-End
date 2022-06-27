package com.yurakcompany.techservice.subscription.domain.persistence;

import com.yurakcompany.techservice.subscription.domain.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    Subscription findByBusinessId (Long BusinessId);
}
