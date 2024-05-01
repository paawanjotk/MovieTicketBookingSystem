package com.lost.movieticketbookingsystem.exceptions;

public class BookingNotFoundException extends RuntimeException{

    public BookingNotFoundException(String message){
        super(message);
    }

}
