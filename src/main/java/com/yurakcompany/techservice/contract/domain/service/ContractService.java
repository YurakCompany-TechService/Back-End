package com.yurakcompany.techservice.contract.domain.service;

import com.yurakcompany.techservice.contract.domain.model.Contract;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ContractService {
    List<Contract> getAll();
    Contract getById(Long id);
    Contract create(Long BusinessId, Contract contract);
    ResponseEntity<?> delete(Long ContractId);
}
