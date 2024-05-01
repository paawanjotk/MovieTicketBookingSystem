package com.lost.movieticketbookingsystem.models;

import java.util.Date;

public class Pair {
    String movie;
    Date showTime;

    public Pair(String movie, Date showTime) {
        this.movie = movie;
        this.showTime = showTime;
    }

    public String getMovie() {
        return movie;
    }

    public Date getShowTime() {
        return showTime;
    }
}

