package com.yurakcompany.techservice.qualification.service;

import com.yurakcompany.techservice.qualification.domain.model.Rating;
import com.yurakcompany.techservice.qualification.domain.persistence.RatingRepository;
import com.yurakcompany.techservice.qualification.domain.persistence.ReviewRepository;
import com.yurakcompany.techservice.qualification.domain.service.RatingService;
import com.yurakcompany.techservice.shared.exception.ResourceNotFoundException;
import com.yurakcompany.techservice.shared.exception.ResourceValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class RatingServiceImpl implements RatingService {

    private static final String ENTITY = "Rating";
    private final RatingRepository ratingRepository;
    private final Validator validator;
    private final ReviewRepository reviewRepository;

    public RatingServiceImpl(RatingRepository ratingRepository, Validator validator, ReviewRepository reviewRepository) {
        this.ratingRepository = ratingRepository;
        this.validator = validator;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Rating> getAll() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating getById(Long id) {
        return ratingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public Rating create(Long ReviewId, Rating rating) {
        Set<ConstraintViolation<Rating>> violations = validator.validate(rating);

        if(!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        return reviewRepository.findById(ReviewId).map(review -> {
            rating.setReview(review);
            return ratingRepository.save(rating);
        }).orElseThrow(()->new ResourceNotFoundException("Review", ReviewId));
    }

    @Override
    public ResponseEntity<?> delete(Long RatingId) {
        return ratingRepository.findById(RatingId).map(rating -> {
            ratingRepository.delete(rating);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, RatingId));
    }
}
