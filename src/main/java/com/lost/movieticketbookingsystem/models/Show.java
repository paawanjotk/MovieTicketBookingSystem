package com.lost.movieticketbookingsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Entity
@Getter
@Setter

public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date showTime;
    @ManyToOne
    private Movie movie;
    private Double price;
    @ManyToOne
    private CinemaHall cinemaHall = new CinemaHall(200L);

    private Long availableSeats;
    private Long filledSeats;

//    public Show() {
//        this.availableSeats = cinemaHall.getCapacity();
//        this.filledSeats = 0L;
//
//    }

    public Long getAvailableSeats() {
        return availableSeats = cinemaHall.getCapacity() - filledSeats;
    }


}
