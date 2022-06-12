package com.yurakcompany.demo.portfolio.domain.service;


import com.yurakcompany.demo.portfolio.domain.model.Portfolio;
import org.springframework.http.ResponseEntity;

public interface PortfolioService {
    Portfolio getById(Long portfolioId);
    Portfolio create(Portfolio portfolio);
    Portfolio update(Long portfolioId, Portfolio request);
    ResponseEntity<?> delete(Long portfolioId);
}
