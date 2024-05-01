package com.lost.movieticketbookingsystem.services;

import com.lost.movieticketbookingsystem.dtos.ShowDto;
import com.lost.movieticketbookingsystem.models.Show;
import com.lost.movieticketbookingsystem.repositories.ShowRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("showServices")

public class ShowServices {

    ShowRepository showRepository;

    public ShowServices(@Qualifier("showRepository") ShowRepository showRepository){
        this.showRepository = showRepository;
    }

    public ShowDto create(Show show){
        ShowDto showDto = new ShowDto();

        showDto.setId(show.getId());
        showDto.setMovieName(show.getMovie().getTitle());
        showDto.setCinemaHallId(show.getCinemaHall().getId());
        showDto.setShowTime(show.getShowTime());
        showDto.setAvailableSeats(show.getAvailableSeats());
        showDto.setFilledSeats(show.getFilledSeats());
        showRepository.save(show);

        return showDto;
    }
}



