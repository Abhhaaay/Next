package com.example.next.seeding;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.next.entity.Image;
import com.example.next.entity.Movie;
import com.example.next.repository.ImageRepository;
import com.example.next.repository.MovieRepository;

import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class PeriodicSqlExecutor {

    private static final Logger logger = LoggerFactory.getLogger(PeriodicSqlExecutor.class);

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ImageRepository imageRepository;

    private int counter = 1;

    @Scheduled(initialDelay = 60000, fixedRate = 120000)
public void executeSqlScript() {
    Resource resource = resourceLoader.getResource("classpath:sql/data" + counter + ".sql");
    try (Connection connection = dataSource.getConnection()) {
        ScriptUtils.executeSqlScript(connection, resource);
        insertImagesForNewMovies();
    } catch (Exception e) {
        logger.error("Error refreshing data", e);
    }
    counter++;
}

private void insertImagesForNewMovies() {
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
    }
}