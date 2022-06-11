package com.yurakcompany.demo.register.resource;

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
