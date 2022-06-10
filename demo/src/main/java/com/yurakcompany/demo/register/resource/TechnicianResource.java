package com.yurakcompany.demo.register.resource;

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

    //User
    private String email;
    private String password;
    private Long phone;
}
