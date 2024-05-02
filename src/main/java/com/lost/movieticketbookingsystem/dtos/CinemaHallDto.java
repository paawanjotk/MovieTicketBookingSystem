package com.lost.movieticketbookingsystem.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CinemaHallDto {
    private Long id;
    private String name;
    private String location;
    private Long capacity;
    private String available_technology;
}
