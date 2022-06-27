package com.yurakcompany.techservice.security.register.domain.model;

import com.yurakcompany.techservice.shared.domain.model.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "businesses")
public class Business extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
}
