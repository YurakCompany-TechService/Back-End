package com.yurakcompany.techservice.security.register.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class TechnicianResource {
    private Long id;

    private String firstName;
    private String lastName;
    private String gender;
    private String brand;
    private String area;
    private String type;

    //User
    private String email;
    private String password;
    private int phone;
}
