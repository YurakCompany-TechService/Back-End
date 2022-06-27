package com.yurakcompany.techservice.contract.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("contractMappingConfiguration")
public class MappingConfiguration {
    @Bean
    ContractMapper contractMapper() { return new ContractMapper(); }
}
