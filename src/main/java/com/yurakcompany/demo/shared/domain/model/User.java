package com.yurakcompany.demo.shared.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.*;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Column(name = "email", nullable = false)
    @NotNull
    @NotBlank
    @Email
    private String email;
    @Column(name = "password", nullable = false)
    @NotNull
    @NotBlank
    private String password;
    @Column(name = "phone", nullable = false)
    @Digits(integer = 9, fraction = 0)
    @NotNull
    private int phone;
}
