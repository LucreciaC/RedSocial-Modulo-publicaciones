package com.RedSocial.publicaciones.service;

import com.RedSocial.publicaciones.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    //Nos devuelve un listado completo de los usuarios
    List<User> findAll();
    //Busca por id
    Optional<User> findById(Long id);
    //
    void save(User user);

    void deleteById(Long id);
}
