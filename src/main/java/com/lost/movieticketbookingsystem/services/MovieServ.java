package com.lost.movieticketbookingsystem.services;

import com.lost.movieticketbookingsystem.models.Movie;

import java.util.List;

public interface MovieServ {

    Movie getById(Long id);

    List<Movie> getAll();

    Movie create(Movie movie);

    Movie update(Long id, Movie movie);

    void delete(Long id);
}
