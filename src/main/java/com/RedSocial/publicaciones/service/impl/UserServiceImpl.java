package com.RedSocial.publicaciones.service.impl;

import com.RedSocial.publicaciones.entities.User;
import com.RedSocial.publicaciones.persistence.IUserDAO;
import com.RedSocial.publicaciones.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDAO userDAO;

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userDAO.findById(id);
    }

    @Transactional
    @Override
    public void save(User user) {
        userDAO.save(user);

    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        userDAO.deleteById(id);
    }
}
