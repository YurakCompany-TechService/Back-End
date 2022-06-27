package com.yurakcompany.techservice.contract.api;

import com.yurakcompany.techservice.contract.domain.service.ContractService;
import com.yurakcompany.techservice.contract.mapping.ContractMapper;
import com.yurakcompany.techservice.contract.resource.ContractResource;
import com.yurakcompany.techservice.contract.resource.CreateContractResource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/business/{businessId}/contracts")
public class BusinessContractsController {
    private final ContractService contractService;
    private final ContractMapper mapper;

    public BusinessContractsController(ContractService contractService, ContractMapper mapper) {
        this.contractService = contractService;
        this.mapper = mapper;
    }

    @PostMapping
    public ContractResource create(@PathVariable Long businessId, @RequestBody CreateContractResource resource) {
        return mapper.toResource(contractService.create(businessId, mapper.toModel(resource)));
    }
}
