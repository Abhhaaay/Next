
package com.example.next.controller;

import com.example.next.entity.Image;
import com.example.next.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping
    public List<Image> getAllImages() {
        return imageService.getAllImages();
    }

    @PostMapping
    public Image addImage(@RequestBody Image image) {
        return imageService.addImage(image);
    }
}