package com.example.next.seeding;

import com.example.next.entity.Image;
import com.example.next.entity.Movie;
import com.example.next.repository.ImageRepository;
import com.example.next.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public void run(String... args) throws Exception {
        String[] imageUrls = {
            "https://th.bing.com/th/id/OIP.xbcMlYnxaNR3p0Uu-Ks3XAHaLH?rs=1&pid=ImgDetMain",
            "https://i.pinimg.com/736x/57/7f/da/577fda8c298782a778f9e9cdb4065434.jpg",
            "https://i.pinimg.com/originals/69/99/f3/6999f3102d23fea43621f50f19778043.jpg"
        };

        List<Movie> movies = movieRepository.findAll();
        for (Movie movie : movies) {
            for (String url : imageUrls) {
                
                if (imageRepository.findByImgUrlAndMovie_Id(url, movie.getId()) == null) {
                    Image image = new Image();
                    image.setImgUrl(url);
                    image.setMovie(movie);
                    imageRepository.save(image);
                }
            }
        }

        System.out.println("Images initialized.");
    }
}