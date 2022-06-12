package com.yurakcompany.demo.notification.domain.model;

import com.yurakcompany.demo.register.domain.model.Business;
import com.yurakcompany.demo.register.domain.model.Technician;
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
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String description;

    @NotNull
    @NotBlank
    private String title;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "technician_id", nullable = true)
    private Technician technician;

    //@ManyToOne(fetch = FetchType.LAZY, optional = true)
    //@JoinColumn(name = "business_id", nullable = true)
    //private Business business;
}
