package com.yurakcompany.demo.notification.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateNotificationResource {
    @NotNull
    @NotBlank
    private String description;

    @NotNull
    @NotBlank
    private String title;
}
