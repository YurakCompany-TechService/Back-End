package com.yurakcompany.demo.contract.domain.service;

import com.yurakcompany.demo.contract.domain.model.Contract;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ContractService {
    List<Contract> getAll();
    Contract getById(Long id);
    Contract create(Long BusinessId, Contract contract);
    ResponseEntity<?> delete(Long ContractId);
}
