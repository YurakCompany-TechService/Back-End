package com.yurakcompany.demo.security.register.domain.model;

import com.yurakcompany.demo.shared.domain.model.User;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "business")
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
