package com.techservice.backend.domain.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "request")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 300)
    private String description;


    @Size(max = 50)
    private String product_brand;

    private int time;

    private int date;

    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(unique = true)
    private Long id_business_customer;

}
