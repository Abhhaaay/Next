package com.example.next.repository;

import com.example.next.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
    Image findByImgUrlAndMovie_Id(String imgUrl, Long movieId);
}