package com.yurakcompany.demo.portfolio.service;

import com.yurakcompany.demo.portfolio.domain.model.Portfolio;
import com.yurakcompany.demo.portfolio.domain.persistence.PortfolioRepository;
import com.yurakcompany.demo.portfolio.domain.service.PortfolioService;
import com.yurakcompany.demo.shared.exception.ResourceNotFoundException;
import com.yurakcompany.demo.shared.exception.ResourceValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Service
public class PortfolioServiceImpl implements PortfolioService {
    private static final String ENTITY = "Portfolio";

    private final PortfolioRepository portfolioRepository;

    private final Validator validator;

    public PortfolioServiceImpl(PortfolioRepository portfolioRepository, Validator validator) {
        this.portfolioRepository = portfolioRepository;
        this.validator = validator;
    }

    @Override
    public Portfolio getById(Long portfolioId) {
        return portfolioRepository.findById(portfolioId).orElseThrow(()-> new ResourceNotFoundException(ENTITY, portfolioId));
    }

    @Override
    public Portfolio create(Portfolio portfolio) {
        Set<ConstraintViolation<Portfolio>>violations = validator.validate(portfolio);
        if(!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }
        return portfolioRepository.save(portfolio);
    }

    @Override
    public Portfolio update(Long portfolioId, Portfolio request) {
        Set<ConstraintViolation<Portfolio>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        // Name Uniqueness validation

        /*Portfolio portfolioWithId = portfolioRepository.findById(request.getId());

        if (portfolioWithId != null && !portfolioWithId.getId().equals(portfolioId))
            throw new ResourceValidationException(ENTITY,
                    "An student with the same name already exists.");
*/
        return portfolioRepository.findById(portfolioId).map(portfolio ->
                        portfolioRepository.save(portfolio.withId(request.getId()).
                                withDescription(request.getDescription())))
                        .orElseThrow(() -> new ResourceNotFoundException(ENTITY, portfolioId));
    }

    @Override
    public ResponseEntity<?> delete(Long portfolioId) {
        return portfolioRepository.findById(portfolioId).map(portfolio -> {
            portfolioRepository.delete(portfolio);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, portfolioId));
    }
}
