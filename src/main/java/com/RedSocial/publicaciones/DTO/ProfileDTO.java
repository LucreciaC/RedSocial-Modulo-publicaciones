package com.RedSocial.publicaciones.DTO;

import com.RedSocial.publicaciones.entities.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileDTO {
    private Long id;

    private String biography;

    private String avatar;

    private User user;
}
