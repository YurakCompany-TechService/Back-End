package com.yurakcompany.demo.portfolio.api;

import com.yurakcompany.demo.portfolio.domain.service.PortfolioService;
import com.yurakcompany.demo.portfolio.mapping.PortfolioMapper;
import com.yurakcompany.demo.portfolio.resource.PortfolioResource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/portfolios")
public class PortfoliosController {
    private final PortfolioService portfolioService;

    private final PortfolioMapper mapper;

    public PortfoliosController(PortfolioService portfolioService, PortfolioMapper mapper) {
        this.portfolioService = portfolioService;
        this.mapper = mapper;
    }

    @GetMapping("{portfolioId}")
    public PortfolioResource getById(@PathVariable Long portfolioId) {
        return mapper.toResource(portfolioService.getById(portfolioId));
    }
}
