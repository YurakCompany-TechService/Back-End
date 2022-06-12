package com.yurakcompany.demo.qualification.mapping;

import com.yurakcompany.demo.qualification.domain.model.Rating;
import com.yurakcompany.demo.qualification.resource.CreateRatingResource;
import com.yurakcompany.demo.qualification.resource.RatingResource;
import com.yurakcompany.demo.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class RatingMapper {
    @Autowired
    EnhancedModelMapper mapper;
    public RatingResource toResource(Rating model) { return mapper.map(model, RatingResource.class); }
    public Rating toModel(CreateRatingResource resource) { return mapper.map(resource, Rating.class); }
}
