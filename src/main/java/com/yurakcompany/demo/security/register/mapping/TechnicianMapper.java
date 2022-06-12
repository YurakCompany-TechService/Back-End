package com.yurakcompany.demo.security.register.mapping;

import com.yurakcompany.demo.security.register.domain.model.Technician;
import com.yurakcompany.demo.security.register.resource.CreateTechnicianResource;
import com.yurakcompany.demo.security.register.resource.TechnicianResource;
import com.yurakcompany.demo.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class TechnicianMapper {
    @Autowired
    EnhancedModelMapper mapper;
    public TechnicianResource toResource(Technician model){
        return mapper.map(model,TechnicianResource.class);
    }
    public Technician toModel(CreateTechnicianResource resource){
        return mapper.map(resource, Technician.class);
    }
}
