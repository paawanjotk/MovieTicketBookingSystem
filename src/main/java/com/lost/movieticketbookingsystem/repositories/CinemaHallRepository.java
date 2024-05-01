package com.lost.movieticketbookingsystem.repositories;

import com.lost.movieticketbookingsystem.models.CinemaHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("cinemaHallRepository")
public interface CinemaHallRepository extends JpaRepository<CinemaHall, Long> {
    @Override
    Optional<CinemaHall> findById(Long id);

    @Override

    CinemaHall save(CinemaHall cinemaHall);
}
