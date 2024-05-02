package com.lost.movieticketbookingsystem.services;

import com.lost.movieticketbookingsystem.models.CustomerProfile;

import java.util.List;

public interface CustomerServ {

    CustomerProfile getById(Long id);

    List<CustomerProfile> getAll();

    CustomerProfile create(CustomerProfile customerProfile);

    CustomerProfile update(Long id, CustomerProfile customerProfile);

    void delete(Long id);
}
