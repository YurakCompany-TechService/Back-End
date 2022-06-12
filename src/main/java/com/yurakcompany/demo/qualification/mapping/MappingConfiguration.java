package com.yurakcompany.demo.qualification.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("qualificationMappingConfiguration")
public class MappingConfiguration {
    @Bean
    ReviewMapper reviewMapper() { return new ReviewMapper(); }
    @Bean
    RatingMapper ratingMapper() { return new RatingMapper(); }
}
