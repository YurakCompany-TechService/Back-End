package com.yurakcompany.techservice.qualification.api;

import com.yurakcompany.techservice.qualification.domain.service.ReviewService;
import com.yurakcompany.techservice.qualification.mapping.ReviewMapper;
import com.yurakcompany.techservice.qualification.resource.CreateReviewResource;
import com.yurakcompany.techservice.qualification.resource.ReviewResource;
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
