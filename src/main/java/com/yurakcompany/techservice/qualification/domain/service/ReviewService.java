package com.yurakcompany.techservice.qualification.domain.service;

import com.yurakcompany.techservice.qualification.domain.model.Review;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReviewService {
    List<Review> getAll();
    Review getById(Long id);
    Review create(Long ContractId, Review review);
    ResponseEntity<?> delete(Long ReviewId);
}
