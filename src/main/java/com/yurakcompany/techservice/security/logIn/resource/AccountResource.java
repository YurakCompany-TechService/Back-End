package com.yurakcompany.techservice.security.logIn.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class AccountResource {
    private String email;
    private String password;
}
