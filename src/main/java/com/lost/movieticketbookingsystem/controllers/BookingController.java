package com.lost.movieticketbookingsystem.controllers;

import com.lost.movieticketbookingsystem.models.Booking;
import com.lost.movieticketbookingsystem.services.BookingServices;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    BookingServices  bookingServices;

    public BookingController(@Qualifier("bookingServices") BookingServices bookingServices){
        this.bookingServices = bookingServices;
    }

    @GetMapping("/bookings/{id}")
    public Booking getById(@PathVariable("id") Long id){
        return bookingServices.getById(id);
    }
    @GetMapping("/bookings")
    public List<Booking> getAll(){
        return bookingServices.getAll();
    }

    @PostMapping("/bookings")
    public Booking create(@RequestBody Booking booking){

        return bookingServices.create(booking);
    }


    @PutMapping("/bookings/{id}")
    public Booking update(@PathVariable("id") Long  Id, @RequestBody Booking booking){
        return bookingServices.update(Id, booking);
    }

    @DeleteMapping("/bookings/{id}")
    public void delete(@PathVariable("id") Long Id){
        bookingServices.delete(Id);
    }

    @GetMapping("/customer/bookings/{customerId}")
    public List<Booking> getBookingByCustomerId(@PathVariable("customerId") Long customerId){
        return bookingServices.getBookingByCustomerId(customerId);
    }
    @GetMapping("/movies/bookings/{movieId}")
    public List<Booking> getBookingByMovieId(@PathVariable("movieId") Long movieId){
            return bookingServices.getBookingByMovieId(movieId);
    }
    @GetMapping("/cinemaHall/bookings/{cinemaHallId}")
    public List<Booking> getBookingByCinemaHallId(@PathVariable("cinemaHallId") Long cinemaHallId){
        return bookingServices.getBookingByCinemaHallId(cinemaHallId);
    }

}
