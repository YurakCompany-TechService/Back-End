package com.yurakcompany.demo.qualification.domain.model;

import com.yurakcompany.demo.contract.domain.model.Contract;
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
@Table(name = "ratings")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long starPoints;

    @OneToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "review_id", nullable = true)
    private Review review;
}
