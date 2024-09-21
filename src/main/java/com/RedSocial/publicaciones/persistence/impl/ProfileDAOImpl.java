package com.RedSocial.publicaciones.persistence.impl;

import com.RedSocial.publicaciones.entities.Profile;
import com.RedSocial.publicaciones.persistence.IProfileDAO;
import com.RedSocial.publicaciones.repository.ProfileRepository;
import com.RedSocial.publicaciones.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class ProfileDAOImpl implements IProfileDAO {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public List<Profile> findAll() {
        return (List<Profile>) profileRepository.findAll();
    }

    @Override
    public Optional<Profile> findById(Long id) {
        return profileRepository.findById(id);
    }

    @Override
    public void save(Profile profile) {
        profileRepository.save(profile);
    }

    @Override
    public void deleteById(Long id) {
        profileRepository.deleteById(id);
    }
}
