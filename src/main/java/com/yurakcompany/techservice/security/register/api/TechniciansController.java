package com.yurakcompany.techservice.security.register.api;

import com.yurakcompany.techservice.security.register.domain.service.TechnicianService;
import com.yurakcompany.techservice.security.register.mapping.TechnicianMapper;
import com.yurakcompany.techservice.security.register.resource.CreateTechnicianResource;
import com.yurakcompany.techservice.security.register.resource.TechnicianResource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/technicians")
@CrossOrigin
public class TechniciansController {
    private final TechnicianService technicianService;
    private final TechnicianMapper mapper;

    public TechniciansController(TechnicianService technicianService, TechnicianMapper mapper) {
        this.technicianService = technicianService;
        this.mapper = mapper;
    }

    @GetMapping("{technicianId}")
    public TechnicianResource getById(@PathVariable Long technicianId){
        return mapper.toResource(technicianService.getById(technicianId));
    }
    @PostMapping
    public TechnicianResource create(@RequestBody CreateTechnicianResource resource){
        return mapper.toResource(technicianService.create(mapper.toModel(resource)));
    }
}
