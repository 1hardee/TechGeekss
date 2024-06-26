package com.hardishastri.ecommercemicroservices.imageservice.controller;

import com.hardishastri.ecommercemicroservices.imageservice.entity.Image;
import com.hardishastri.ecommercemicroservices.imageservice.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping
    public ResponseEntity<Image> uploadImage(@RequestParam("title") String title,
                                             @RequestParam("file") MultipartFile file) throws IOException {
        Image image = imageService.saveImage(title, file);
        return ResponseEntity.ok(image);
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        Optional<Image> imageData = imageService.getImage(id);

        if (imageData.isPresent()) {
            return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(imageData.get().getData());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
