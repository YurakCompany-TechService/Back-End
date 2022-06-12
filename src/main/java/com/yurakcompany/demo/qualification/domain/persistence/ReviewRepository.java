package com.yurakcompany.demo.qualification.domain.persistence;

import com.yurakcompany.demo.qualification.domain.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Review findByContractId(Long ContractId);
}
