package com.yurakcompany.techservice.contract.domain.persistence;

import com.yurakcompany.techservice.contract.domain.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    Contract findByBusinessId(Long BusinessId);
}
