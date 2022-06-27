package com.yurakcompany.techservice.qualification.resource;

import com.yurakcompany.techservice.contract.resource.ContractResource;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResource {
    private Long id;

    private String description;

    private ContractResource contract;
}
