package com.lost.movieticketbookingsystem.services;

import com.lost.movieticketbookingsystem.dtos.BookingDto;
import com.lost.movieticketbookingsystem.models.Booking;

import java.util.List;

public interface BookingServ {
    public BookingDto getById(Long id);
    public List<BookingDto> getAll();
    public Booking create(Booking booking);
    public Booking update(Long id,Booking booking);
    public void delete(Long id);
    public List<Booking> getBookingByCustomerId(Long customerId);
    public List<Booking> getBookingByMovieId(Long movieId);
    public List<Booking> getBookingByCinemaHallId(Long cinemaHallId);
}







