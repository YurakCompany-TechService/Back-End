package com.yurakcompany.demo.register.service;

import com.yurakcompany.demo.register.domain.model.Business;
import com.yurakcompany.demo.register.domain.persistence.BusinessRepository;
import com.yurakcompany.demo.register.domain.service.BusinessService;
import com.yurakcompany.demo.shared.exception.ResourceNotFoundException;
import com.yurakcompany.demo.shared.exception.ResourceValidationException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;


@Service
public class BusinessServiceImpl implements BusinessService {
    private static final String ENTITY = "Business";
    private final BusinessRepository businessRepository;
    private final Validator validator;

    public BusinessServiceImpl(BusinessRepository businessRepository, Validator validator) {
        this.businessRepository = businessRepository;
        this.validator = validator;
    }

    @Override
    public Business getById(Long id) {
        return businessRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public Business create(Business business) {
        Set<ConstraintViolation<Business>> violations = validator.validate(business);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        return businessRepository.save(business);
    }
}
