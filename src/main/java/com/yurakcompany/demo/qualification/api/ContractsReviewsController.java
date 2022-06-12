package com.yurakcompany.demo.qualification.api;

import com.yurakcompany.demo.qualification.domain.model.Review;
import com.yurakcompany.demo.qualification.domain.service.ReviewService;
import com.yurakcompany.demo.qualification.mapping.ReviewMapper;
import com.yurakcompany.demo.qualification.resource.CreateReviewResource;
import com.yurakcompany.demo.qualification.resource.ReviewResource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/contracts/{contractId}/reviews")
public class ContractsReviewsController {
    private final ReviewService reviewService;
    private final ReviewMapper mapper;

    public ContractsReviewsController(ReviewService reviewService, ReviewMapper mapper) {
        this.reviewService = reviewService;
        this.mapper = mapper;
    }

    @PostMapping
    public ReviewResource create(@PathVariable Long contractId, @RequestBody CreateReviewResource resource) {
        return mapper.toResource(reviewService.create(contractId, mapper.toModel(resource)));
    }
}
