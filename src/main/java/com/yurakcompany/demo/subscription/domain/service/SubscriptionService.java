package com.yurakcompany.demo.subscription.domain.service;

import com.yurakcompany.demo.subscription.domain.model.Subscription;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SubscriptionService {
    List<Subscription> getAll();
    Subscription getById(Long id);
    Subscription create(Long BusinessId, Subscription subscription);
    ResponseEntity<?> delete(Long SubscriptionId);
}
