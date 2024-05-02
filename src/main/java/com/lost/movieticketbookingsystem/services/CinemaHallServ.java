package com.lost.movieticketbookingsystem.services;

import com.lost.movieticketbookingsystem.models.CinemaHall;
import com.lost.movieticketbookingsystem.models.Pair;

import java.util.List;

public interface CinemaHallServ {

    CinemaHall getById(Long id);

    List<CinemaHall> getAll();

    CinemaHall create(CinemaHall cinemaHall);

    CinemaHall update(Long id, CinemaHall cinemaHall);

    void delete(Long id);

    List<Pair> getMovieShowTimeByCinemaHallId(Long cinemaHallId);
}
