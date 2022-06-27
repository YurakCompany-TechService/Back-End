package com.yurakcompany.techservice.security.register.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("registerMappingConfiguration")
public class MappingConfiguration {
    @Bean TechnicianMapper technicianMapper(){
        return new TechnicianMapper();
    }
    @Bean BusinessMapper businessMapper(){
        return new BusinessMapper();
    }
}
