package com.RedSocial.publicaciones.DTO;

import com.RedSocial.publicaciones.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDTO {

    private Long id;

    private String contenido;

    private LocalDateTime fechaCreacion;

    private Long userId;

    private int likes;
}
