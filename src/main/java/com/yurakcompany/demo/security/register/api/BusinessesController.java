package com.yurakcompany.demo.security.register.api;

import com.yurakcompany.demo.security.register.domain.service.BusinessService;
import com.yurakcompany.demo.security.register.mapping.BusinessMapper;
import com.yurakcompany.demo.security.register.resource.BusinessResource;
import com.yurakcompany.demo.security.register.resource.CreateBusinessResource;
import org.springframework.web.bind.annotation.*;

@RestController
    @RequestMapping("/api/v1/businesses")
    @CrossOrigin
    public class BusinessesController {
        private final BusinessService businessService;
    private final BusinessMapper mapper;

    public BusinessesController(BusinessService businessService, BusinessMapper mapper) {
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
