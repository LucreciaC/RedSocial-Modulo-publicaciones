package com.RedSocial.publicaciones.service;

import com.RedSocial.publicaciones.entities.Post;

import java.util.List;
import java.util.Optional;

public interface IPostService {

    List<Post> findAll();

    Optional<Post> findById(Long id);

    void save(Post post);

    void deleteById(Long id);

}
