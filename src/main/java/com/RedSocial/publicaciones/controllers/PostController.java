package com.RedSocial.publicaciones.controllers;

import com.RedSocial.publicaciones.DTO.PostDTO;
import com.RedSocial.publicaciones.entities.Post;
import com.RedSocial.publicaciones.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private IPostService postService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Post> postOptional = postService.findById(id);

        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            PostDTO postDTO = PostDTO.builder()
                    .id(post.getId())
                    .contenido(post.getContenido())
                    .fechaCreacion(post.getFechaCreacion())
                    .userId(post.getUser().getId())  // Aquí asumimos que necesitas el ID del usuario
                    .likes(post.getLikes().size())
                    .build();
            return ResponseEntity.ok(postDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<PostDTO> postDTOList = postService.findAll().stream()
                .map(post -> PostDTO.builder()
                        .id(post.getId())
                        .contenido(post.getContenido())
                        .fechaCreacion(post.getFechaCreacion())
                        .userId(post.getUser().getId())// Aquí asumimos que necesitas el ID del usuario
                        .likes(post.getLikes().size())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(postDTOList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody PostDTO postDTO) throws URISyntaxException {
        if (postDTO.getContenido().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        Post post = Post.builder()
                .contenido(postDTO.getContenido())
                .fechaCreacion(LocalDateTime.now())
                .build();

        // Asignar el usuario al post si es necesario (depende de cómo se maneje en tu servicio)
        // Ejemplo: post.setUser(userService.findById(postDTO.getUserId()).orElse(null));

        postService.save(post);

        return ResponseEntity.created(new URI("/api/post/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePost(@PathVariable Long id, @RequestBody PostDTO postDTO) {
        Optional<Post> postOptional = postService.findById(id);

        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            post.setContenido(postDTO.getContenido());
            post.setFechaCreacion(postDTO.getFechaCreacion());
            // Actualizar otros campos según sea necesario
            postService.save(post);
            return ResponseEntity.ok("Publicación actualizada exitosamente");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        if (id != null) {
            postService.deleteById(id);
            return ResponseEntity.ok("Publicación eliminada exitosamente");
        }
        return ResponseEntity.badRequest().build();
    }
}
