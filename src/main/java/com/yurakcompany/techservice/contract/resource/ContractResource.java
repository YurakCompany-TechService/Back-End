package com.yurakcompany.techservice.contract.resource;

import com.yurakcompany.techservice.security.register.resource.BusinessResource;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ContractResource {
    private Long id;

    private String description;

    private BusinessResource business;
}
