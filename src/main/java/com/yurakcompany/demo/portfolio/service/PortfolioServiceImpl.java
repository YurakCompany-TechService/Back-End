package com.yurakcompany.demo.portfolio.service;

import com.yurakcompany.demo.portfolio.domain.model.Portfolio;
import com.yurakcompany.demo.portfolio.domain.persistence.PortfolioRepository;
import com.yurakcompany.demo.portfolio.domain.service.PortfolioService;
import com.yurakcompany.demo.security.register.domain.persistence.TechnicianRepository;
import com.yurakcompany.demo.shared.exception.ResourceNotFoundException;
import com.yurakcompany.demo.shared.exception.ResourceValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class PortfolioServiceImpl implements PortfolioService {
    private static final String ENTITY = "Portfolio";

    private final PortfolioRepository portfolioRepository;
    private final Validator validator;
    private final TechnicianRepository technicianRepository;

    public PortfolioServiceImpl(PortfolioRepository portfolioRepository, Validator validator, TechnicianRepository technicianRepository) {
        this.portfolioRepository = portfolioRepository;
        this.validator = validator;
        this.technicianRepository = technicianRepository;
    }

    @Override
    public List<Portfolio> getAll() {
        return portfolioRepository.findAll();
    }

    @Override
    public Portfolio getById(Long portfolioId) {
        return portfolioRepository.findById(portfolioId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, portfolioId));
    }

    @Override
    public Portfolio create(Long technicianId, Portfolio portfolio) {
        Set<ConstraintViolation<Portfolio>> violations = validator.validate(portfolio);

        if(!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }
        return technicianRepository.findById(technicianId).map(technician -> {
            portfolio.setTechnician(technician);
            return portfolioRepository.save(portfolio);
        }).orElseThrow(() -> new ResourceNotFoundException("Technician", technicianId));
    }

    @Override
    public ResponseEntity<?> delete(Long portfolioId) {
        return portfolioRepository.findById(portfolioId).map(portfolio -> {
            portfolioRepository.delete(portfolio);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, portfolioId));
    }
}
