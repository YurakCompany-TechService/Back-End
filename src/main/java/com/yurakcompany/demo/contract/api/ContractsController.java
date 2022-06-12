package com.yurakcompany.demo.contract.api;

import com.yurakcompany.demo.contract.domain.model.Contract;
import com.yurakcompany.demo.contract.domain.service.ContractService;
import com.yurakcompany.demo.contract.mapping.ContractMapper;
import com.yurakcompany.demo.contract.resource.ContractResource;
import com.yurakcompany.demo.contract.resource.CreateContractResource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contracts")
public class ContractsController {
    private final ContractService contractService;
    private final ContractMapper mapper;

    public ContractsController(ContractService contractService, ContractMapper mapper) {
        this.contractService = contractService;
        this.mapper = mapper;
    }

    @GetMapping("{contractId}")
    public ContractResource getById(@PathVariable Long contractId) {
        return mapper.toResource(contractService.getById(contractId));
    }

}
