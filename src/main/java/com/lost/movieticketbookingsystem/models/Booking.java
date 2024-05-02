package com.lost.movieticketbookingsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Booking{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private Long customerId;
    private Long movieId;
    private Long CinemaHallId;
    private Long tickets;
    @ManyToOne //
    private Shows shows;
    private Long price;


}
