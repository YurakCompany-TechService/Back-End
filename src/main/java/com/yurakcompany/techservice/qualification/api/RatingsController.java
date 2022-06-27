package com.yurakcompany.techservice.qualification.api;

import com.yurakcompany.techservice.qualification.domain.service.RatingService;
import com.yurakcompany.techservice.qualification.mapping.RatingMapper;
import com.yurakcompany.techservice.qualification.resource.RatingResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ratings")
public class RatingsController {
    private final RatingService ratingService;
    private final RatingMapper mapper;

    public RatingsController(RatingService ratingService, RatingMapper mapper) {
        this.ratingService = ratingService;
        this.mapper = mapper;
    }

    @GetMapping("{ratingId}")
    public RatingResource getById(@PathVariable Long ratingId) {
        return mapper.toResource(ratingService.getById(ratingId));
    }
}
