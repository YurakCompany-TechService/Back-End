package com.yurakcompany.techservice.qualification.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateReviewResource {
    @NotNull
    @NotBlank
    private String description;
}
