package com.yurakcompany.techservice.qualification.domain.persistence;

import com.yurakcompany.techservice.qualification.domain.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Review findByContractId(Long ContractId);
}
