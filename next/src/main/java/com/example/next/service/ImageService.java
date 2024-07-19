
package com.example.next.service;

import com.example.next.entity.Image;
import com.example.next.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    public Image addImage(Image image) {
        return imageRepository.save(image);
    }
}