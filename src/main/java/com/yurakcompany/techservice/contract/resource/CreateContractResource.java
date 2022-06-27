package com.yurakcompany.techservice.contract.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateContractResource {
    @NotNull
    @NotBlank
    private String description;
}
