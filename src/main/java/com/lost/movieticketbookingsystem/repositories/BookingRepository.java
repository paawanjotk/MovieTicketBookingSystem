package com.lost.movieticketbookingsystem.repositories;

import com.lost.movieticketbookingsystem.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Override
    Optional<Booking> findById(Long id);

    @Override
    Booking save(Booking booking);

    List<Booking> findByCustomerId(Long customerId);


}
