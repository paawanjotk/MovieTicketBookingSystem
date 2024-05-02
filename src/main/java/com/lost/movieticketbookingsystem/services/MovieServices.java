package com.lost.movieticketbookingsystem.services;

import com.lost.movieticketbookingsystem.dtos.MovieDto;
import com.lost.movieticketbookingsystem.exceptions.MovieNotFoundException;
import com.lost.movieticketbookingsystem.models.Movie;
import com.lost.movieticketbookingsystem.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("movieServices")

public class MovieServices {

    MovieRepository movieRepository;

    public MovieServices(@Qualifier("movieRepository") MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }


    public MovieDto getById(Long Id){
        Optional<Movie> movie = movieRepository.findById(Id);
        if(movie.isEmpty()){
            throw new MovieNotFoundException("Movie not found");
        }
        return convertToDto(movie.get());
    }

    public List<MovieDto> getAll(){
        List<Movie> movies = movieRepository.findAll();
        List<MovieDto> movieDtos = new ArrayList<>();
        for(int i=0; i<movies.size(); i++){
            movieDtos.add(convertToDto(movies.get(i)));
        }
        return movieDtos;
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
    public MovieDto convertToDto(Movie movie){
        MovieDto movieDto = new MovieDto();
        movieDto.setId(movie.getId());
        movieDto.setTitle(movie.getTitle());
        movieDto.setDirector(movie.getDirector());
        movieDto.setGenre(movie.getGenre());
        movieDto.setRuntime(movie.getRuntime());
        movieDto.setReleaseDate(movie.getReleaseDate());
        return movieDto;
    }

}
