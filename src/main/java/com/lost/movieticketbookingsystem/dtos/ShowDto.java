package com.lost.movieticketbookingsystem.dtos;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter



public class ShowDto {
    private Long id;
    private Date showTime;
    private Long  cinemaHallId;
    private String movieName;
    private Long availableSeats;
    private Long filledSeats;





}
