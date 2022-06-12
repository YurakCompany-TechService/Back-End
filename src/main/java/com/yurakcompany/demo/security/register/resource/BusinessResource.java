package com.yurakcompany.demo.security.register.resource;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class BusinessResource {
    private Long id;

    private String subscription;
    private String name;
    private int creditCard;
    private int cvv;
    private String type;

    //User
    private String email;
    private String password;
    private int phone;

}
