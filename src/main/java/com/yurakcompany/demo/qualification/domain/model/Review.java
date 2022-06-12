package com.yurakcompany.demo.qualification.domain.model;

import com.yurakcompany.demo.contract.domain.model.Contract;
import com.yurakcompany.demo.register.domain.model.Business;
import com.yurakcompany.demo.register.domain.model.Technician;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

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
