package com.yurakcompany.techservice.portfolio.resource;

import com.yurakcompany.techservice.security.register.resource.TechnicianResource;
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
