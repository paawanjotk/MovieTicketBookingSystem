package com.lost.movieticketbookingsystem.services;

import com.lost.movieticketbookingsystem.dtos.CustomerDto;
import com.lost.movieticketbookingsystem.models.CustomerProfile;

import java.util.List;

public interface CustomerServ {

    CustomerDto getById(Long id);

    List<CustomerDto> getAll();

    CustomerProfile create(CustomerProfile customerProfile);

    CustomerProfile update(Long id, CustomerProfile customerProfile);

    void delete(Long id);
}
