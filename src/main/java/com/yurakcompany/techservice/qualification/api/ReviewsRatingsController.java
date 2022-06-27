package com.yurakcompany.techservice.qualification.api;

import com.yurakcompany.techservice.qualification.domain.service.RatingService;
import com.yurakcompany.techservice.qualification.mapping.RatingMapper;
import com.yurakcompany.techservice.qualification.resource.CreateRatingResource;
import com.yurakcompany.techservice.qualification.resource.RatingResource;
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
