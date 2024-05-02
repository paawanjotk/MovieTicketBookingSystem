package com.lost.movieticketbookingsystem.controllers;

import com.lost.movieticketbookingsystem.dtos.ShowDto;
import com.lost.movieticketbookingsystem.models.Shows;
import com.lost.movieticketbookingsystem.services.ShowServices;
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

    public ShowDto create(@RequestBody Shows shows){

        return showServices.create(shows);
    }


}
