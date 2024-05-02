package com.lost.movieticketbookingsystem.services;

import com.lost.movieticketbookingsystem.exceptions.CinemaHallNotFoundException;
import com.lost.movieticketbookingsystem.exceptions.MovieNotFoundException;
import com.lost.movieticketbookingsystem.models.CinemaHall;
import com.lost.movieticketbookingsystem.models.Pair;
import com.lost.movieticketbookingsystem.models.Shows;
import com.lost.movieticketbookingsystem.repositories.CinemaHallRepository;
import com.lost.movieticketbookingsystem.repositories.MovieRepository;
import com.lost.movieticketbookingsystem.repositories.ShowRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service("cinemaHallServices")
public class CinemaHallServices {

    CinemaHallRepository cinemaHallRepository;
    ShowRepository showRepository;
    MovieRepository movieRepository;

    public CinemaHallServices(@Qualifier("cinemaHallRepository") CinemaHallRepository cinemaHallRepository, @Qualifier("showRepository") ShowRepository showRepository, @Qualifier("movieRepository") MovieRepository movieRepository){
        this.cinemaHallRepository = cinemaHallRepository;
        this.showRepository = showRepository;
        this.movieRepository = movieRepository;
    }

    public CinemaHall getById(Long Id){
        Optional<CinemaHall> cinemaHall = cinemaHallRepository.findById(Id);
        if(cinemaHall.isEmpty()){
            throw new CinemaHallNotFoundException("CinemaHall not found");
        }
        return cinemaHall.get();
    }

    public List<CinemaHall> getAll(){
        return cinemaHallRepository.findAll();
    }
    public CinemaHall create(CinemaHall cinemaHall){
        return cinemaHallRepository.save(cinemaHall);
    }

    public CinemaHall update(Long Id, CinemaHall cinemaHall) {
        CinemaHall cinemaHall1 = cinemaHallRepository.findById(Id)
                .orElseThrow(() -> new CinemaHallNotFoundException("CinemaHall not found"));

        cinemaHall1.setName(cinemaHall.getName());
        cinemaHall1.setCapacity(cinemaHall.getCapacity());
        cinemaHall1.setLocation(cinemaHall.getLocation());
        cinemaHall1.setAvailable_technology(cinemaHall.getAvailable_technology());

        cinemaHallRepository.save(cinemaHall1);

        return cinemaHall1;

    }

    public void delete(Long Id){
        cinemaHallRepository.deleteById(Id);
    }
    public List<Pair> getMovieShowTimeByCinemaHallId(Long cinemaHallId){
        List<Shows> allShows = showRepository.findAll();

        for(int i = 0; i < allShows.size(); i++){
            if(!allShows.get(i).getCinemaHallId().equals(cinemaHallId)){
                allShows.remove(i);
            }
        }

        List<Pair> pairs = new ArrayList<>();
        for(int i = 0; i < allShows.size(); i++){
            String movieTitle = movieRepository.findById(allShows.get(i).getMovieId())
                    .orElseThrow(() -> new MovieNotFoundException("Movie not found")).getTitle();
            pairs.add(new Pair(movieTitle, allShows.get(i).getShowTime()));
        }

        return pairs;
    }




}
