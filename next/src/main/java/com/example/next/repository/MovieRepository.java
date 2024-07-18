package com.example.next.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.next.entity.Movie;

/*
 * --If your SQL file is named data.sql and located in src/main/resources, 
--Spring Boot automatically runs it on startup without additional configuration.
-- This is done using the DataSourceInitializer.
 */

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{
    Optional<Movie> findByTitle(String title);
    List<Movie> findByTitleContaining(String query);
}
