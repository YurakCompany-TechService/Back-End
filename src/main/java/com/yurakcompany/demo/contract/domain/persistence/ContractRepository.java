package com.yurakcompany.demo.contract.domain.persistence;

import com.yurakcompany.demo.contract.domain.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    Contract findByBusinessId(Long BusinessId);
}
