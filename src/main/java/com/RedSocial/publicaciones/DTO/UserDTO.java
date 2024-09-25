package com.RedSocial.publicaciones.DTO;

import com.RedSocial.publicaciones.entities.Post;
import com.RedSocial.publicaciones.entities.Profile;
import com.RedSocial.publicaciones.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private Long id;

    private String name;

    private String email;

    private Profile profile;

    private List<Post> post;

    private Set<User> seguidores;

    private Set<User> siguiendo;

    private int likedPosts;

}
