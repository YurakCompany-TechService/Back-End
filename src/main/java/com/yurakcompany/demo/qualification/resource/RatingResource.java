package com.yurakcompany.demo.qualification.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class RatingResource {
    private Long id;

    private Long starPoints;

    private ReviewResource review;
}
