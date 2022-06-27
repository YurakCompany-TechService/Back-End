package com.yurakcompany.techservice.qualification.resource;

import lombok.*;

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
