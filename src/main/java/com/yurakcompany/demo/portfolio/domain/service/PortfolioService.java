package com.yurakcompany.demo.portfolio.domain.service;


import com.yurakcompany.demo.portfolio.domain.model.Portfolio;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PortfolioService {
    List<Portfolio> getAll();
    Portfolio getById(Long portfolioId);
    Portfolio create(Long technicianId, Portfolio portfolio);
    ResponseEntity<?> delete(Long portfolioId);
}
