package com.yurakcompany.demo.qualification.api;

import com.yurakcompany.demo.contract.resource.ContractResource;
import com.yurakcompany.demo.qualification.domain.service.ReviewService;
import com.yurakcompany.demo.qualification.mapping.ReviewMapper;
import com.yurakcompany.demo.qualification.resource.CreateReviewResource;
import com.yurakcompany.demo.qualification.resource.ReviewResource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewsController {
    private final ReviewService reviewService;
    private final ReviewMapper mapper;

    public ReviewsController(ReviewService reviewService, ReviewMapper mapper) {
        this.reviewService = reviewService;
        this.mapper = mapper;
    }

    @GetMapping("{reviewId}")
    public ReviewResource getById(@PathVariable Long reviewId) {
        return mapper.toResource(reviewService.getById(reviewId));
    }
}
