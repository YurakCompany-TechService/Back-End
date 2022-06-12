package com.yurakcompany.demo.qualification.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateRatingResource {
    @NotNull
    private Long starPoints;
}
