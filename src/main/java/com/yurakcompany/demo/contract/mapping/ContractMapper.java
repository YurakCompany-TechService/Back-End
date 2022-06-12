package com.yurakcompany.demo.contract.mapping;

import com.yurakcompany.demo.contract.domain.model.Contract;
import com.yurakcompany.demo.contract.resource.ContractResource;
import com.yurakcompany.demo.contract.resource.CreateContractResource;
import com.yurakcompany.demo.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ContractMapper {
    @Autowired
    EnhancedModelMapper mapper;
    public ContractResource toResource(Contract model) { return mapper.map(model, ContractResource.class); }
    public Contract toModel(CreateContractResource resource) { return mapper.map(resource, Contract.class); }
}
