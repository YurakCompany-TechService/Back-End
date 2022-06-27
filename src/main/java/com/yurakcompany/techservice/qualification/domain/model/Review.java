package com.yurakcompany.techservice.qualification.domain.model;

import com.yurakcompany.techservice.contract.domain.model.Contract;
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
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String description;

    @OneToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "contract_id", nullable = true)
    private Contract contract;
}
