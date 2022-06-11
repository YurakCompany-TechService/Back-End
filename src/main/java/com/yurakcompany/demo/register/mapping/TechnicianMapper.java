package com.yurakcompany.demo.register.mapping;

import com.yurakcompany.demo.register.domain.model.Technician;
import com.yurakcompany.demo.register.resource.CreateTechnicianResource;
import com.yurakcompany.demo.register.resource.TechnicianResource;
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
