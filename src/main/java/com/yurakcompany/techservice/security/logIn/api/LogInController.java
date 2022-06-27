package com.yurakcompany.techservice.security.logIn.api;

import com.yurakcompany.techservice.security.register.domain.model.Business;
import com.yurakcompany.techservice.security.register.domain.model.Technician;
import com.yurakcompany.techservice.security.register.domain.service.BusinessService;
import com.yurakcompany.techservice.security.register.domain.service.TechnicianService;
import com.yurakcompany.techservice.security.logIn.resource.AccountResource;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/logIn")
public class LogInController {
    private final BusinessService businessService;
    private final TechnicianService technicianService;

    public LogInController(BusinessService businessService, TechnicianService technicianService) {
        this.businessService = businessService;
        this.technicianService = technicianService;
    }
    @PostMapping("/businesses")
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
