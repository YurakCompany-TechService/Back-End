package com.yurakcompany.techservice.contract.api;

import com.yurakcompany.techservice.contract.domain.service.ContractService;
import com.yurakcompany.techservice.contract.mapping.ContractMapper;
import com.yurakcompany.techservice.contract.resource.ContractResource;
import org.springframework.web.bind.annotation.*;

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
