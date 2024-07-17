package com.example.next.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.next.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{
    Optional<Movie> findByTitle(String title);
}
