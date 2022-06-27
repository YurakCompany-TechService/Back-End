package com.yurakcompany.techservice.qualification.domain.service;

import com.yurakcompany.techservice.qualification.domain.model.Rating;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RatingService {
    List<Rating> getAll();
    Rating getById(Long id);
    Rating create(Long ReviewId, Rating rating);
    ResponseEntity<?> delete(Long RatingId);
}
