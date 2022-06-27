package com.yurakcompany.techservice.contract.mapping;

import com.yurakcompany.techservice.contract.domain.model.Contract;
import com.yurakcompany.techservice.contract.resource.ContractResource;
import com.yurakcompany.techservice.contract.resource.CreateContractResource;
import com.yurakcompany.techservice.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ContractMapper {
    @Autowired
    EnhancedModelMapper mapper;
    public ContractResource toResource(Contract model) { return mapper.map(model, ContractResource.class); }
    public Contract toModel(CreateContractResource resource) { return mapper.map(resource, Contract.class); }
}
