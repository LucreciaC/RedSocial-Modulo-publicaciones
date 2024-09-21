package com.RedSocial.publicaciones.controllers;

import com.RedSocial.publicaciones.DTO.ProfileDTO;
import com.RedSocial.publicaciones.entities.Profile;
import com.RedSocial.publicaciones.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    private IProfileService profileService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Profile> profileOptional = profileService.findById(id);

        if (profileOptional.isPresent()) {
            Profile profile = profileOptional.get();
            ProfileDTO profileDTO = ProfileDTO.builder()
                    .id(profile.getId())
                    .biography(profile.getBiography())
                    .avatar(profile.getAvatar())
                    .user(profile.getUser()) // Incluyendo el usuario asociado
                    .build();

            return ResponseEntity.ok(profileDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<ProfileDTO> profileList = profileService.findAll()
                .stream()
                .map(profile -> ProfileDTO.builder()
                        .id(profile.getId())
                        .biography(profile.getBiography())
                        .avatar(profile.getAvatar())
                        .user(profile.getUser()) // Incluyendo el usuario asociado
                        .build())
                .toList();

        return ResponseEntity.ok(profileList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProfileDTO profileDTO) throws URISyntaxException {
        if (profileDTO.getBiography().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        Profile profile = Profile.builder()
                .biography(profileDTO.getBiography())
                .avatar(profileDTO.getAvatar())
                .build();

        profileService.save(profile);

        return ResponseEntity.created(new URI("/api/profile/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProfile(@PathVariable Long id, @RequestBody ProfileDTO profileDTO) {
        Optional<Profile> profileOptional = profileService.findById(id);

        if (profileOptional.isPresent()) {
            Profile profile = profileOptional.get();
            profile.setBiography(profileDTO.getBiography());
            profile.setAvatar(profileDTO.getAvatar());
            profileService.save(profile);
            return ResponseEntity.ok("Registro actualizado con éxito");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        if(id != null){
            profileService.deleteById(id);
            return ResponseEntity.ok("Registro eliminado con éxito");
        }
        return ResponseEntity.badRequest().build();
    }
}
