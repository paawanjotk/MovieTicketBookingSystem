package com.lost.movieticketbookingsystem.dtos;

import com.lost.movieticketbookingsystem.models.Shows;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingDto {
    Long id;
    private Long customerId;
    private Long movieId;
    private Long CinemaHallId;
    private Long tickets;
    private Shows shows;
    private Double price;
}
