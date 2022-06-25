package com.yurakcompany.demo.portfolio.api;

import com.yurakcompany.demo.portfolio.domain.service.PortfolioService;
import com.yurakcompany.demo.portfolio.mapping.PortfolioMapper;
import com.yurakcompany.demo.portfolio.resource.CreatePortfolioResource;
import com.yurakcompany.demo.portfolio.resource.PortfolioResource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/technicians/{technicianId}/portfolios")
public class TechniciansPortfoliosController {
    private final PortfolioService portfolioService;
    private final PortfolioMapper mapper;

    public TechniciansPortfoliosController(PortfolioService portfolioService, PortfolioMapper mapper) {
        this.portfolioService = portfolioService;
        this.mapper = mapper;
    }

    @PostMapping
    public PortfolioResource create(@PathVariable Long technicianId, @RequestBody CreatePortfolioResource resource) {
        return mapper.toResource(portfolioService.create(technicianId, mapper.toModel(resource)));
    }
}
