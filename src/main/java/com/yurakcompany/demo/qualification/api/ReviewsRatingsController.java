package com.yurakcompany.demo.qualification.api;

import com.yurakcompany.demo.qualification.domain.service.RatingService;
import com.yurakcompany.demo.qualification.domain.service.ReviewService;
import com.yurakcompany.demo.qualification.mapping.RatingMapper;
import com.yurakcompany.demo.qualification.resource.CreateRatingResource;
import com.yurakcompany.demo.qualification.resource.CreateReviewResource;
import com.yurakcompany.demo.qualification.resource.RatingResource;
import com.yurakcompany.demo.qualification.resource.ReviewResource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reviews/{reviewId}/ratings")
public class ReviewsRatingsController {
    private final RatingService ratingService;
    private final RatingMapper mapper;

    public ReviewsRatingsController(RatingService ratingService, RatingMapper mapper) {
        this.ratingService = ratingService;
        this.mapper = mapper;
    }
    @PostMapping
    public RatingResource create(@PathVariable Long reviewId, @RequestBody CreateRatingResource resource) {
        return mapper.toResource(ratingService.create(reviewId, mapper.toModel(resource)));
    }
}
