package com.lost.movieticketbookingsystem.repositories;

import com.lost.movieticketbookingsystem.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository("movieRepository")
public interface MovieRepository extends JpaRepository<Movie, Long>{
    @Override
    Optional<Movie> findById(Long id);
    @Override
    Movie save(Movie movie);
}
