package com.yurakcompany.demo.qualification.domain.persistence;

import com.yurakcompany.demo.qualification.domain.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    Rating findByReviewId(Long ReviewId);
}
