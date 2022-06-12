package com.yurakcompany.demo.qualification.resource;

import com.yurakcompany.demo.contract.resource.ContractResource;
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
