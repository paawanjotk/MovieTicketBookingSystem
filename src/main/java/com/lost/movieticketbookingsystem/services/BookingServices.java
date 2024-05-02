package com.lost.movieticketbookingsystem.services;

import com.lost.movieticketbookingsystem.dtos.BookingDto;
import com.lost.movieticketbookingsystem.exceptions.BookingNotFoundException;
import com.lost.movieticketbookingsystem.models.Booking;
import com.lost.movieticketbookingsystem.models.Movie;
import com.lost.movieticketbookingsystem.models.Shows;
import com.lost.movieticketbookingsystem.repositories.BookingRepository;
import com.lost.movieticketbookingsystem.repositories.CinemaHallRepository;
import com.lost.movieticketbookingsystem.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("bookingServices")
public class BookingServices implements BookingServ {

    BookingRepository bookingRepository;

    MovieRepository movieRepository;

    CinemaHallRepository cinemaHallRepository;


    public BookingServices(@Qualifier("bookingRepository")BookingRepository bookingRepository, @Qualifier("movieRepository") MovieRepository movieRepository, @Qualifier("cinemaHallRepository") CinemaHallRepository cinemaHallRepository){
        this.bookingRepository = bookingRepository;
        this.cinemaHallRepository = cinemaHallRepository;
        this.movieRepository = movieRepository;
    }

    public BookingDto getById(Long id){
        Optional<Booking> booking = bookingRepository.findById(id);

        if(booking.isEmpty()){
            throw new BookingNotFoundException("Booking not found");
        }


        return convertToDto(booking.get());

    }

   public List<BookingDto> getAll(){
       List<Booking> bookings =  bookingRepository.findAll();
       List<BookingDto> bookingDtos = new ArrayList<>();
       for(int i=0; i<bookings.size(); i++){
           bookingDtos.add(convertToDto(bookings.get(i)));
       }
       return bookingDtos;
   }

    public Booking create(Booking booking){
        Long movieId = booking.getMovieId();
        Optional<Movie> movie=movieRepository.findById(movieId);

        if(movie.isEmpty()){
            throw new RuntimeException("Movie not found");
        }

        Shows show  = booking.getShows();
        if(show.getAvailableSeats() < booking.getTickets()){
            throw new RuntimeException("Not enough seats available");
        }
        show.setAvailableSeats(show.getAvailableSeats() - booking.getTickets());
        show.setFilledSeats(show.getFilledSeats() + booking.getTickets());
        booking.setPrice(show.getPrice() * booking.getTickets());
        return bookingRepository.save(booking);
    }

    public Booking update(Long Id, Booking booking){
        Booking booking1 = bookingRepository.findById(Id)
                .orElseThrow(() -> new BookingNotFoundException("Booking not found"));

        booking1.setShows(booking.getShows());
        booking1.setTickets(booking.getTickets());
        booking1.setPrice(booking.getPrice());
        booking1.setMovieId(booking.getMovieId());
        booking1.setCustomerId(booking.getCustomerId());

        bookingRepository.save(booking1);

        return booking1;
    }

    public void delete(Long Id){
        bookingRepository.deleteById(Id);
    }
    public List<Booking> getBookingByCustomerId(Long customerId){
        List<Booking> allBookings = bookingRepository.findAll();
        for(int i = 0; i < allBookings.size(); i++){
            if(!allBookings.get(i).getCustomerId().equals(customerId)){
                allBookings.remove(i);
            }
        }
        return allBookings;
    }

    public List<Booking> getBookingByMovieId(Long movieId){
        List<Booking> allBookings = bookingRepository.findAll();
        for(int i = 0; i < allBookings.size(); i++){
            if(!allBookings.get(i).getMovieId().equals(movieId)){
                allBookings.remove(i);
            }
        }
        return allBookings;
    }

    public List<Booking> getBookingByCinemaHallId(Long cinemaHallId){
        List<Booking> allBookings = bookingRepository.findAll();
        for(int i = 0; i < allBookings.size(); i++){
            if(!allBookings.get(i).getCinemaHallId().equals(cinemaHallId)){
                allBookings.remove(i);
            }
        }
        return allBookings;
    }
    public BookingDto convertToDto(Booking booking){
        BookingDto bookingDto = new BookingDto();
        bookingDto.setId(booking.getId());
        bookingDto.setCustomerId(booking.getCustomerId());
        bookingDto.setMovieId(booking.getMovieId());
        bookingDto.setShows(booking.getShows());
        bookingDto.setTickets(booking.getTickets());
        bookingDto.setPrice(booking.getPrice());
        return bookingDto;
    }
}
