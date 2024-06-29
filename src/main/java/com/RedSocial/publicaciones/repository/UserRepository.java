package com.RedSocial.publicaciones.repository;

import com.RedSocial.publicaciones.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository <User, Long> {
}
