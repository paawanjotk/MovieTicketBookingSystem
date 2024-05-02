package com.lost.movieticketbookingsystem.services;

import com.lost.movieticketbookingsystem.dtos.ShowDto;
import com.lost.movieticketbookingsystem.models.Shows;

public interface ShowServ {

    ShowDto create(Shows shows);
}
