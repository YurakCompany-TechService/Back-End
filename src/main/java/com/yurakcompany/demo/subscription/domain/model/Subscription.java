package com.yurakcompany.demo.subscription.domain.model;

import com.yurakcompany.demo.security.register.domain.model.Business;
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
@Table(name = "subscriptions")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String type;

    @OneToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "business_id", nullable = true)
    private Business business;
}
