package com.lost.movieticketbookingsystem.repositories;

import com.lost.movieticketbookingsystem.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("showRepository")
public interface ShowRepository extends JpaRepository<Show, Long> {
    @Override
    Optional<Show> findById(Long id);
    @Override
    Show save(Show show);



}
