package com.RedSocial.publicaciones.repository;

import com.RedSocial.publicaciones.entities.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository <Profile, Long> {
}
