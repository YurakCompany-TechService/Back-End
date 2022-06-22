package com.yurakcompany.demo.contract.service;

import com.yurakcompany.demo.contract.domain.model.Contract;
import com.yurakcompany.demo.contract.domain.persistence.ContractRepository;
import com.yurakcompany.demo.contract.domain.service.ContractService;
import com.yurakcompany.demo.security.register.domain.persistence.BusinessRepository;
import com.yurakcompany.demo.shared.exception.ResourceNotFoundException;
import com.yurakcompany.demo.shared.exception.ResourceValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class ContractServiceImpl implements ContractService {
    private static final String ENTITY = "Contract";
    private final ContractRepository contractRepository;
    private final Validator validator;
    private final BusinessRepository businessRepository;

    public ContractServiceImpl(ContractRepository contractRepository, Validator validator, BusinessRepository businessRepository) {
        this.contractRepository = contractRepository;
        this.validator = validator;
        this.businessRepository = businessRepository;
    }

    @Override
    public List<Contract> getAll() {
        return contractRepository.findAll();
    }

    @Override
    public Contract getById(Long id) {
        return contractRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public Contract create(Long BusinessId, Contract contract) {
        Set<ConstraintViolation<Contract>>violations = validator.validate(contract);

        if(!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        return businessRepository.findById(BusinessId).map(business -> {
            contract.setBusiness(business);
            return contractRepository.save(contract);
        }).orElseThrow(()-> new ResourceNotFoundException("Business", BusinessId));
    }

    @Override
    public ResponseEntity<?> delete(Long ContractId) {
        return contractRepository.findById(ContractId).map(contract -> {
            contractRepository.delete(contract);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, ContractId));
    }
}
