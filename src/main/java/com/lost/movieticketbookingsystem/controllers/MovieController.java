package com.lost.movieticketbookingsystem.controllers;

import com.lost.movieticketbookingsystem.dtos.MovieDto;
import com.lost.movieticketbookingsystem.models.Movie;
import com.lost.movieticketbookingsystem.services.MovieServ;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController


public class MovieController {

    MovieServ movieServices;

    public MovieController(@Qualifier("movieServices") MovieServ movieServices){
        this.movieServices = movieServices;
    }


    @GetMapping("/movie/{id}")
    public MovieDto getById(@PathVariable("id") Long id){
        return movieServices.getById(id);
    }

    @GetMapping("/movie")
    public List<MovieDto> getAll(){
        return movieServices.getAll();
    }


    @PostMapping("/movie")
    public Movie create(@RequestBody Movie movie){
        return movieServices.create(movie);
    }

    @PutMapping("/movie/{id}")
    public Movie update(@PathVariable("id") Long id,  @RequestBody Movie movie){
        return movieServices.update(id, movie);
    }


    @DeleteMapping("/movie/{id}")
    public void delete(@PathVariable("id") Long Id){
        movieServices.delete(Id);

    }


}
