package com.RedSocial.publicaciones.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

//Anotaciones lombok
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//Anotaciones JPA
@Entity
@Table(name = "Publicacion")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contenido;
    private LocalDateTime fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    @JsonIgnore
    private User user;
}
