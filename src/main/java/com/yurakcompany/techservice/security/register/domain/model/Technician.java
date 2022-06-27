package com.yurakcompany.techservice.security.register.domain.model;

import com.yurakcompany.techservice.shared.domain.model.User;
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
@Table(name="technicians")
public class Technician extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
}
