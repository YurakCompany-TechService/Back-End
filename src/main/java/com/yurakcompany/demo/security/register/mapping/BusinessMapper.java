package com.yurakcompany.demo.security.register.mapping;

import com.yurakcompany.demo.security.register.domain.model.Business;
import com.yurakcompany.demo.security.register.resource.BusinessResource;
import com.yurakcompany.demo.security.register.resource.CreateBusinessResource;
import com.yurakcompany.demo.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BusinessMapper {
    @Autowired
    EnhancedModelMapper mapper;
    public BusinessResource toResource(Business model){
        return mapper.map(model,BusinessResource.class);
    }
    public Business toModel(CreateBusinessResource resource){
        return mapper.map(resource, Business.class);
    }
}
