package com.yurakcompany.techservice.security.register.mapping;

import com.yurakcompany.techservice.security.register.domain.model.Technician;
import com.yurakcompany.techservice.security.register.resource.CreateTechnicianResource;
import com.yurakcompany.techservice.security.register.resource.TechnicianResource;
import com.yurakcompany.techservice.shared.mapping.EnhancedModelMapper;
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
