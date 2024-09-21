package com.RedSocial.publicaciones.service;

import com.RedSocial.publicaciones.entities.Profile;

import java.util.List;
import java.util.Optional;

public interface IProfileService {
    List<Profile> findAll();

    Optional<Profile> findById(Long id);

    void save(Profile profile);

    void deleteById(Long id);
}
