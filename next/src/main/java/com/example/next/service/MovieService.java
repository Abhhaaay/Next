package com.example.next.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.next.entity.Movie;
import com.example.next.repository.MovieRepository;

@Service
public class MovieService {
    
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMoviesWithCalculatedPrice() {
        List<Movie> movies = StreamSupport.stream(movieRepository.findAll().spliterator(), false)
            .collect(Collectors.toList());

        List<Movie> uniqueMovies = filterForLowerPrice(movies);

        return uniqueMovies.stream()
            .map(movie -> {
                double calculatedPrice = calculatePrice(movie.getPrice(), movie.getRating());
                movie.setPrice(calculatedPrice);
                return movie;
            })
            .collect(Collectors.toList());
    }

    private List<Movie> filterForLowerPrice(List<Movie> movies) {
        HashMap<String, Movie> movieMap = new HashMap<>();
        for (Movie movie : movies) {
            movieMap.merge(movie.getTitle(), movie, (existing, newMovie) ->
                existing.getPrice() < newMovie.getPrice() ? existing : newMovie);
        }
        return new ArrayList<>(movieMap.values());
    }

    private double calculatePrice(double price, int rating) {
        return price + (0.1 * rating * price);
    }

}