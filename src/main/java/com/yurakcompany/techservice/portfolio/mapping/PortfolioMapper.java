package com.yurakcompany.techservice.portfolio.mapping;

import com.yurakcompany.techservice.portfolio.domain.model.Portfolio;
import com.yurakcompany.techservice.portfolio.resource.CreatePortfolioResource;
import com.yurakcompany.techservice.portfolio.resource.PortfolioResource;
import com.yurakcompany.techservice.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class PortfolioMapper {
    @Autowired
    EnhancedModelMapper mapper;

    public PortfolioResource toResource(Portfolio model) { return mapper.map(model, PortfolioResource.class); }
    public Portfolio toModel(CreatePortfolioResource resource) { return mapper.map(resource, Portfolio.class); }
}
