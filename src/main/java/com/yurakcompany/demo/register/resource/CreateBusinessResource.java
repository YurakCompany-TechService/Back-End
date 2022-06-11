package com.yurakcompany.demo.register.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor

public class CreateBusinessResource {
    @NotNull
    @NotBlank
    private String subscription;
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    private int creditCard;
    @NotNull
    private int cvv;
    @NotNull
    @NotBlank
    private String type;
    //User
    @NotNull
    @NotBlank
    private String email;
    @NotNull
    @NotBlank
    private String password;
    @NotNull
    private int phone;
}
