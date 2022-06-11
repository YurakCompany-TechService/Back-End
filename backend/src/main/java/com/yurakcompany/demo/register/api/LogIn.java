package com.yurakcompany.demo.register.api;

import com.yurakcompany.demo.register.domain.model.Business;
import com.yurakcompany.demo.register.domain.model.Technician;
import com.yurakcompany.demo.register.domain.service.BusinessService;
import com.yurakcompany.demo.register.domain.service.TechnicianService;
import com.yurakcompany.demo.register.resource.AccountResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/logIn")
public class LogIn {
    private final BusinessService businessService;
    private final TechnicianService technicianService;

    public LogIn(BusinessService businessService, TechnicianService technicianService) {
        this.businessService = businessService;
        this.technicianService = technicianService;
    }
    @PostMapping("/business")
        public Business getAccountBusiness(@RequestBody AccountResource resource){
            if (businessService.getAccount(resource.getEmail(), resource.getPassword()) != null){
                System.out.println(businessService.getAccount(resource.getEmail(), resource.getPassword()));
                return businessService.getAccount(resource.getEmail(),resource.getPassword());
            }
            return null;
        }
        @PostMapping("/technician")
        public Technician getAccountTechnician(@RequestBody AccountResource resource){
            if (technicianService.getAccount(resource.getEmail(), resource.getPassword()) != null) {
            System.out.println(technicianService.getAccount(resource.getEmail(), resource.getPassword()));
            return technicianService.getAccount(resource.getEmail(), resource.getPassword());
        }
        return null;
    }
}
