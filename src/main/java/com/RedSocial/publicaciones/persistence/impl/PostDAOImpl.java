package com.RedSocial.publicaciones.persistence.impl;

import com.RedSocial.publicaciones.entities.Post;
import com.RedSocial.publicaciones.persistence.IPostDAO;
import com.RedSocial.publicaciones.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PostDAOImpl implements IPostDAO {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> findAll() {

        return (List<Post>) postRepository.findAll();
    }

    @Override
    public Optional<Post> findById(Long id) {

        return postRepository.findById(id);
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
}
