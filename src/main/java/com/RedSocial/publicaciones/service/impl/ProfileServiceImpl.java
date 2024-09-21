package com.RedSocial.publicaciones.service.impl;

import com.RedSocial.publicaciones.entities.Profile;
import com.RedSocial.publicaciones.persistence.IProfileDAO;
import com.RedSocial.publicaciones.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements IProfileService {
    @Autowired
    private IProfileDAO profileDAO;

    @Override
    public List<Profile> findAll() {
        return profileDAO.findAll();
    }

    @Override
    public Optional<Profile> findById(Long id) {
        return profileDAO.findById(id);
    }

    @Override
    public void save(Profile profile) {
        profileDAO.save(profile);
    }

    @Override
    public void deleteById(Long id) {
        profileDAO.deleteById(id);
    }
}
