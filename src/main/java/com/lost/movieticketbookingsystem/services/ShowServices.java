package com.lost.movieticketbookingsystem.services;

import com.lost.movieticketbookingsystem.dtos.ShowDto;
import com.lost.movieticketbookingsystem.models.Shows;
import com.lost.movieticketbookingsystem.repositories.ShowRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("showServices")

public class ShowServices implements ShowServ{

    ShowRepository showRepository;
    MovieServices movieServices;


    public ShowServices(@Qualifier("showRepository") ShowRepository showRepository, @Qualifier("movieServices") MovieServices movieServices){
        this.showRepository = showRepository;
        this.movieServices = movieServices;
    }

    public ShowDto create(Shows shows){
        ShowDto showDto = new ShowDto();

        showDto.setId(shows.getId());
        String movieName = movieServices.getById(shows.getMovieId()).getTitle();
        showDto.setMovieName(movieName);
        showDto.setCinemaHallId(shows.getCinemaHallId());
        showDto.setShowTime(shows.getShowTime());
        showDto.setAvailableSeats(shows.getAvailableSeats());
        showDto.setFilledSeats(shows.getFilledSeats());
        showRepository.save(shows);

        return showDto;
    }
}



