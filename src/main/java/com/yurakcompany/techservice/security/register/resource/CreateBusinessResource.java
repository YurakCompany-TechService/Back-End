package com.yurakcompany.techservice.security.register.resource;

import lombok.*;

import javax.validation.constraints.*;

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
    @Digits(integer = 16, fraction = 0)
    private int creditCard;
    @NotNull
    @Digits(integer = 3, fraction = 0)
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
    @Digits(integer = 9, fraction = 0)
    private int phone;
}
