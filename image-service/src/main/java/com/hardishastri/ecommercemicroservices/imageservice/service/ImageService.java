package com.hardishastri.ecommercemicroservices.imageservice.service;

import com.hardishastri.ecommercemicroservices.imageservice.entity.Image;
import com.hardishastri.ecommercemicroservices.imageservice.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class ImageService {

    private final ImageRepository imageRepository;
    private final Path rootLocation; // Directory path where images will be stored

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
        this.rootLocation = Paths.get("images");
    }

    public Image saveImage(MultipartFile file) throws IOException {
        Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));

        Image image = new Image();
        image.setFileName(file.getOriginalFilename());
        image.setMimeType(file.getContentType());
        image.setFileSize(file.getSize());

        return imageRepository.save(image);
    }

    public Optional<Image> getImage(Long id) {
        return imageRepository.findById(id);
    }

    // Other methods for update, delete, etc.
}
