package com.yurakcompany.demo.subscription.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateSubscriptionResource {
    @NotNull
    @NotBlank
    private String type;
}
