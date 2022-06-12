package com.yurakcompany.demo.contract.resource;

import com.yurakcompany.demo.register.resource.BusinessResource;
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
