package com.lost.movieticketbookingsystem.services;

import com.lost.movieticketbookingsystem.exceptions.MovieNotFoundException;
import com.lost.movieticketbookingsystem.models.Movie;
import com.lost.movieticketbookingsystem.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("movieServices")

public class MovieServices implements  MovieServ{

    MovieRepository movieRepository;

    public MovieServices(@Qualifier("movieRepository") MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }


    public Movie getById(Long Id){
        Optional<Movie> movie = movieRepository.findById(Id);
        if(movie.isEmpty()){
            throw new MovieNotFoundException("Movie not found");
        }
        return movie.get();
    }

    public List<Movie> getAll(){
        return movieRepository.findAll();
    }

    public Movie create(Movie movie){
        return movieRepository.save(movie);
    }

    public Movie update(Long Id, Movie movie){
        Movie movie1 = movieRepository.findById(Id)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found"));

        movie1.setTitle(movie.getTitle());
        movie1.setDirector(movie.getDirector());
        movie1.setGenre(movie.getGenre());
        movie1.setRuntime(movie.getRuntime());
        movie1.setReleaseDate(movie.getReleaseDate());

        movieRepository.save(movie1);

        return movie1;

    }

    public void delete(Long Id){
        movieRepository.deleteById(Id);

    }


}
