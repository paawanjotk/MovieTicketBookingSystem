package com.lost.movieticketbookingsystem.controllers;

import com.lost.movieticketbookingsystem.models.Booking;
import com.lost.movieticketbookingsystem.models.Show;
import com.lost.movieticketbookingsystem.services.BookingServices;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    BookingServices  bookingServices;

    public BookingController(@Qualifier("bookingServices") BookingServices bookingServices){
        this.bookingServices = bookingServices;
    }

    @GetMapping("/booking/{id}")
    public Booking getById(@PathVariable("id") Long id){
        return bookingServices.getById(id);
    }
    @GetMapping("/booking")
    public List<Booking> getAll(){
        return bookingServices.getAll();
    }

    @PostMapping("/booking")
    public Booking create(@RequestBody Booking booking){

        return bookingServices.create(booking);
    }


    @PutMapping("/booking/{id}")
    public Booking update(@PathVariable("id") Long  Id, @RequestBody Booking booking){
        return bookingServices.update(Id, booking);
    }

    @DeleteMapping("/booking/{id}")
    public void delete(@PathVariable("id") Long Id){
        bookingServices.delete(Id);
    }

    @GetMapping("/customers/bookings/{customerId}")
    public List<Booking> getBookingByCustomerId(@PathVariable("customerId") Long customerId){
        return bookingServices.getBookingByCustomerId(customerId);
    }


}
