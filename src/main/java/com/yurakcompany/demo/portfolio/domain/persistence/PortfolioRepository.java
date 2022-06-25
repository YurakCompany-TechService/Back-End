package com.yurakcompany.demo.portfolio.domain.persistence;

import com.yurakcompany.demo.portfolio.domain.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    Portfolio findByTechnicianId(Long technicianId);
}
