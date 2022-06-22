package com.yurakcompany.demo.portfolio.mapping;

import com.yurakcompany.demo.portfolio.domain.model.Portfolio;
import com.yurakcompany.demo.portfolio.resource.CreatePortfolioResource;
import com.yurakcompany.demo.portfolio.resource.PortfolioResource;
import com.yurakcompany.demo.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class PortfolioMapper {
    @Autowired
    EnhancedModelMapper mapper;

    public PortfolioResource toResource(Portfolio model) { return mapper.map(model, PortfolioResource.class); }
    public Portfolio toModel(CreatePortfolioResource resource) { return mapper.map(resource, Portfolio.class); }
}
