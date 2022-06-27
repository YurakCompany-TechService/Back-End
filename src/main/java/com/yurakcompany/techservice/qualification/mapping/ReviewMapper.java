package com.yurakcompany.techservice.qualification.mapping;

import com.yurakcompany.techservice.qualification.domain.model.Review;
import com.yurakcompany.techservice.qualification.resource.CreateReviewResource;
import com.yurakcompany.techservice.qualification.resource.ReviewResource;
import com.yurakcompany.techservice.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ReviewMapper {
    @Autowired
    EnhancedModelMapper mapper;
    public ReviewResource toResource(Review model) { return mapper.map(model, ReviewResource.class); }
    public Review toModel(CreateReviewResource resource) { return mapper.map(resource, Review.class); }
}
