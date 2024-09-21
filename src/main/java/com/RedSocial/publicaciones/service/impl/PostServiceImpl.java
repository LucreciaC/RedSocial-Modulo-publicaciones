package com.RedSocial.publicaciones.service.impl;

import com.RedSocial.publicaciones.entities.Post;
import com.RedSocial.publicaciones.persistence.IPostDAO;
import com.RedSocial.publicaciones.repository.PostRepository;
import com.RedSocial.publicaciones.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements IPostService {

    @Autowired
    private IPostDAO postDAO;

    @Override
    public List<Post> findAll() {
        return postDAO.findAll();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postDAO.findById(id);
    }

    @Override
    public void save(Post post) {
        postDAO.save(post);
    }

    @Override
    public void deleteById(Long id) {
        postDAO.deleteById(id);
    }
}
