package com.RedSocial.publicaciones.entities;
import jakarta.persistence.*;
import lombok.*;
//Anotaciones lombok
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//Anotaciones JPA
@Entity
@Table (name = "Perfil")
public class Profile {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "Biografia")
    private String biography;
    @Column (name= "Avatar")
    private String avatar;

    @OneToOne(mappedBy = "profile")
    private User user;
}
