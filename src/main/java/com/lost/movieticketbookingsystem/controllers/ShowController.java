package com.lost.movieticketbookingsystem.controllers;

import com.lost.movieticketbookingsystem.dtos.ShowDto;
import com.lost.movieticketbookingsystem.models.Movie;
import com.lost.movieticketbookingsystem.models.Show;
import com.lost.movieticketbookingsystem.services.ShowServices;
import jakarta.persistence.SqlResultSetMapping;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/show")
public class ShowController {

    ShowServices showServices;

    public ShowController(@Qualifier("showServices") ShowServices showServices){
        this.showServices = showServices;
    }

    @PostMapping

    public ShowDto create(@RequestBody Show show){

        return showServices.create(show);
    }


}
