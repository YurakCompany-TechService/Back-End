package com.yurakcompany.techservice.qualification.service;

import com.yurakcompany.techservice.contract.domain.persistence.ContractRepository;
import com.yurakcompany.techservice.qualification.domain.model.Review;
import com.yurakcompany.techservice.qualification.domain.persistence.ReviewRepository;
import com.yurakcompany.techservice.qualification.domain.service.ReviewService;
import com.yurakcompany.techservice.shared.exception.ResourceNotFoundException;
import com.yurakcompany.techservice.shared.exception.ResourceValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class ReviewServiceImpl implements ReviewService {
    private static final String ENTITY = "Review";
    private final ReviewRepository reviewRepository;
    private final Validator validator;
    private final ContractRepository contractRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, Validator validator, ContractRepository contractRepository) {
        this.reviewRepository = reviewRepository;
        this.validator = validator;
        this.contractRepository = contractRepository;
    }

    @Override
    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getById(Long id) {
        return reviewRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public Review create(Long ContractId, Review review) {
        Set<ConstraintViolation<Review>>violations = validator.validate(review);

        if(!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        return contractRepository.findById(ContractId).map(contract -> {
            review.setContract(contract);
            return reviewRepository.save(review);
        }).orElseThrow(()->new ResourceNotFoundException("Contract", ContractId));
    }

    @Override
    public ResponseEntity<?> delete(Long ReviewId) {
        return reviewRepository.findById(ReviewId).map(review -> {
            reviewRepository.delete(review);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, ReviewId));
    }
}
