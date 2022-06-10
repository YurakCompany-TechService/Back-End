package com.yurakcompany.demo.register.api;

import com.yurakcompany.demo.register.domain.service.BusinessService;
import com.yurakcompany.demo.register.mapping.BusinessMapper;
import com.yurakcompany.demo.register.resource.BusinessResource;
import com.yurakcompany.demo.register.resource.CreateBusinessResource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/business")
@CrossOrigin
public class BusinessController {
    private final BusinessService businessService;
    private final BusinessMapper mapper;

    public BusinessController(BusinessService businessService, BusinessMapper mapper) {
        this.businessService = businessService;
        this.mapper = mapper;
    }
    @GetMapping("{businessId}")
    public BusinessResource getById(@PathVariable Long businessId){
        return mapper.toResource(businessService.getById(businessId));
    }
    @PostMapping
    public BusinessResource create(@RequestBody CreateBusinessResource resource){
        return mapper.toResource(businessService.create(mapper.toModel(resource)));
    }
}
