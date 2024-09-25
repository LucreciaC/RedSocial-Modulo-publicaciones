package com.RedSocial.publicaciones.controllers;

import com.RedSocial.publicaciones.DTO.UserDTO;
import com.RedSocial.publicaciones.entities.User;
import com.RedSocial.publicaciones.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<User> userOptional = userService.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            //Extraemos los atributos del entity y los seteamos en el DTO
            UserDTO userDTO = UserDTO.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .email(user.getEmail())
                    .profile(user.getProfile())
                    .post(user.getPost())
                    .seguidores(user.getSeguidores())
                    .siguiendo(user.getSiguiendo())
                    .likedPosts(user.getLikedPosts().size())
                    .build();

            return ResponseEntity.ok(userDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {

        List<UserDTO> userList = userService.findAll()
                .stream()
                .map(user -> UserDTO.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .email(user.getEmail())
                        .profile(user.getProfile())
                        .post(user.getPost())
                        .seguidores(user.getSeguidores())
                        .siguiendo(user.getSiguiendo())
                        .likedPosts(user.getLikedPosts().size())
                        .build())
                .toList();

        return ResponseEntity.ok(userList);

    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody UserDTO userDTO) throws URISyntaxException {

        if (userDTO.getName().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        userService.save(User.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .build());

        return ResponseEntity.created(new URI("/api/user/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {

        Optional<User> userOptional = userService.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            userService.save(user);
            return ResponseEntity.ok("Registro actualizado com sucesso");
        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {

        if(id != null){
            userService.deleteById(id);
            return ResponseEntity.ok("Registro eliminado com sucesso");
        }
        return ResponseEntity.badRequest().build();
    }
}