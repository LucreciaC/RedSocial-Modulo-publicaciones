package com.RedSocial.publicaciones.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

//Anotaciones lombok
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//Anotaciones JPA
@Entity
@Table (name = "Usuario")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name= "Nombre")
    private String name;
    @Column (name= "Email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "perfil_id", referencedColumnName = "id")
    @JsonIgnore
    private Profile profile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<Post> post;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario_seguidores",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "seguidor_id"))
    @JsonIgnore
    private Set<User> seguidores;

    @ManyToMany(mappedBy = "seguidores")
    @JsonIgnore
    private Set<User> siguiendo;

}
