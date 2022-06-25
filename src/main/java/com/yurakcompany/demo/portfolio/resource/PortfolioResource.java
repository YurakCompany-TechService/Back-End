package com.yurakcompany.demo.portfolio.resource;

import com.yurakcompany.demo.security.register.resource.TechnicianResource;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioResource {
    private Long id;

    private String description;

    private TechnicianResource technician;
}
