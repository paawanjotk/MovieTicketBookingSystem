package com.lost.movieticketbookingsystem.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class MovieDto {
    private Long Id;
    private String Title;
    private String director;
    private String genre;
    private Long runtime;
    private Date releaseDate;
}
