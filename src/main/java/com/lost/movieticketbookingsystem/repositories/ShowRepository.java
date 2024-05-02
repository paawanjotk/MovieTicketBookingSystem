package com.lost.movieticketbookingsystem.repositories;

import com.lost.movieticketbookingsystem.models.Shows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("showRepository")
public interface ShowRepository extends JpaRepository<Shows, Long> {
    @Override
    Optional<Shows> findById(Long id);
    @Override
    Shows save(Shows shows);



}
