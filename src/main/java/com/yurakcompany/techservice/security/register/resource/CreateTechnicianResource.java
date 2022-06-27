package com.yurakcompany.techservice.security.register.resource;

import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateTechnicianResource {

    @NotNull
    @NotBlank
    private String firstName;
    @NotNull
    @NotBlank
    private String lastName;
    @NotNull
    @NotBlank
    private String gender;
    @NotNull
    @NotBlank
    private String brand;
    @NotNull
    @NotBlank
    private String area;
    @NotBlank
    @NotNull
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
