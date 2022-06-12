package com.yurakcompany.demo.qualification.mapping;

import com.yurakcompany.demo.qualification.domain.model.Review;
import com.yurakcompany.demo.qualification.resource.CreateReviewResource;
import com.yurakcompany.demo.qualification.resource.ReviewResource;
import com.yurakcompany.demo.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ReviewMapper {
    @Autowired
    EnhancedModelMapper mapper;
    public ReviewResource toResource(Review model) { return mapper.map(model, ReviewResource.class); }
    public Review toModel(CreateReviewResource resource) { return mapper.map(resource, Review.class); }
}
