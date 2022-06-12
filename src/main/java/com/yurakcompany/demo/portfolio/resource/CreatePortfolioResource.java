package com.yurakcompany.demo.portfolio.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreatePortfolioResource {
    @NotNull
    @NotBlank
    private String description;
}
