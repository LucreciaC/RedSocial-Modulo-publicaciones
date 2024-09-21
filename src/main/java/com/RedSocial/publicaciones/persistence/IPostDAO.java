package com.RedSocial.publicaciones.persistence;

import com.RedSocial.publicaciones.entities.Post;
import com.RedSocial.publicaciones.entities.Profile;

import java.util.List;
import java.util.Optional;

public interface IPostDAO {

    List<Post> findAll();

    Optional<Post> findById(Long id);

    void save(Post post);

    void deleteById(Long id);
}
