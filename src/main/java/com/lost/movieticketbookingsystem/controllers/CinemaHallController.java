package com.lost.movieticketbookingsystem.controllers;

import com.lost.movieticketbookingsystem.models.CinemaHall;
import com.lost.movieticketbookingsystem.models.Pair;
import com.lost.movieticketbookingsystem.services.CinemaHallServices;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

public class CinemaHallController {
    CinemaHallServices cinemaHallServices;

    public CinemaHallController(@Qualifier("cinemaHallServices") CinemaHallServices cinemaHallServices){
        this.cinemaHallServices = cinemaHallServices;
    }
    @GetMapping("/cinemaHall/{id}")
    public CinemaHall getById(@PathVariable("id") Long id){
        return cinemaHallServices.getById(id);
    }
    @GetMapping("/cinemaHall")
    public List<CinemaHall> getAll(){
        return cinemaHallServices.getAll();
    }
    @PostMapping("/cinemaHall")
    public CinemaHall create(@RequestBody CinemaHall cinemaHall){
        return cinemaHallServices.create(cinemaHall);
    }

    @PutMapping("/cinemaHall/{id}")

    public CinemaHall update(@PathVariable("id") Long id,  @RequestBody CinemaHall cinemaHall){
        return cinemaHallServices.update(id, cinemaHall);
    }

    @DeleteMapping("/cinemaHall/{id}")

    public void delete(@PathVariable("id") Long Id){
        cinemaHallServices.delete(Id);
    }

    public List<Pair> getMovieShowTimeByCinemaHallId(Long cinemaHallId){

        return cinemaHallServices.getMovieShowTimeByCinemaHallId(cinemaHallId);
    }


}
