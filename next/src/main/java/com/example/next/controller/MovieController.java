
package com.example.next.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.next.entity.Movie;
import com.example.next.repository.MovieRepository;
import com.example.next.service.MovieService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/movie")
    public List<Movie> getAllMovies() {
        return movieService.getAllMoviesWithCalculatedPrice();
    }

    @GetMapping("/movie/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isPresent()) {
            Movie presentMovie = movie.get(); 
            double calculatedPrice = presentMovie.getPrice() + (0.1 * presentMovie.getRating()*presentMovie.getPrice());
            presentMovie.setPrice(calculatedPrice);
            return presentMovie;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found");
        }
    }

    @GetMapping("/movie/title/{title}")
    public Movie getMovieByName(@PathVariable String title) {
        Optional<Movie> movie = movieRepository.findByTitle(title);
        if (movie.isPresent()) {
            Movie presentMovie = movie.get(); 
            double calculatedPrice = presentMovie.getPrice() + (0.1 * presentMovie.getRating()*presentMovie.getPrice());
            presentMovie.setPrice(calculatedPrice);
            return presentMovie;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found");
        }
    }

    @GetMapping("/movies/search/{query}")
    public List<Movie> getMoviesByLetters(@PathVariable String query){
        return movieService.getMoviesByLetters(query);
    }
}