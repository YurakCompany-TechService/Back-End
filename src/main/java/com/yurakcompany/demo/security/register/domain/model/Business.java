package com.yurakcompany.demo.security.register.domain.model;

import com.yurakcompany.demo.shared.domain.model.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    private int creditCard;
    @NotNull
    private int cvv;
    @NotNull
    @NotBlank
    private String type;
}
