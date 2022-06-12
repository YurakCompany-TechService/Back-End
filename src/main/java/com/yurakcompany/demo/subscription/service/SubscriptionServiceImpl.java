package com.yurakcompany.demo.subscription.service;

import com.yurakcompany.demo.security.register.domain.persistence.BusinessRepository;
import com.yurakcompany.demo.shared.exception.ResourceNotFoundException;
import com.yurakcompany.demo.shared.exception.ResourceValidationException;
import com.yurakcompany.demo.subscription.domain.model.Subscription;
import com.yurakcompany.demo.subscription.domain.persistence.SubscriptionRepository;
import com.yurakcompany.demo.subscription.domain.service.SubscriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    private static final String ENTITY = "Subscription";
    private final SubscriptionRepository subscriptionRepository;
    private final Validator validator;
    private final BusinessRepository businessRepository;

    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository, Validator validator, BusinessRepository businessRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.validator = validator;
        this.businessRepository = businessRepository;
    }

    @Override
    public List<Subscription> getAll() {
        return subscriptionRepository.findAll();
    }

    @Override
    public Subscription getById(Long id) {
        return subscriptionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public Subscription create(Long BusinessId, Subscription subscription) {
        Set<ConstraintViolation<Subscription>>violations = validator.validate(subscription);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        return businessRepository.findById(BusinessId).map(business -> {
            subscription.setBusiness(business);
            return subscriptionRepository.save(subscription);
        }).orElseThrow(()-> new ResourceNotFoundException("Business", BusinessId));
    }

    @Override
    public ResponseEntity<?> delete(Long SubscriptionId) {
        return subscriptionRepository.findById(SubscriptionId).map(subscription -> {
            subscriptionRepository.delete(subscription);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, SubscriptionId));
    }
}
