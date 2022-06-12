package com.yurakcompany.demo.portfolio.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("portfolioMappingConfiguration")
public class MappingConfiguration {
    @Bean
    PortfolioMapper portfolioMapper() { return new PortfolioMapper(); }
}
