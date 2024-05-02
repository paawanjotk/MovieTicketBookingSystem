package com.lost.movieticketbookingsystem.controllers;

import com.lost.movieticketbookingsystem.dtos.CustomerDto;
import com.lost.movieticketbookingsystem.models.CustomerProfile;
import com.lost.movieticketbookingsystem.services.CustomerServ;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    CustomerServ customerServices;

    public CustomerController(@Qualifier("customerServices") CustomerServ customerServices){
        this.customerServices = customerServices;
    }
    @GetMapping("/customer/{id}")
    public CustomerDto getById(@PathVariable("id") Long id){
        return customerServices.getById(id);
    }

    @GetMapping("/customer")
    public List<CustomerDto> getAll(){
        return customerServices.getAll();
    }

    @PostMapping("/customer")
    public CustomerProfile create(@RequestBody CustomerProfile customerProfile){
        return customerServices.create(customerProfile);
    }

    @PutMapping("/customer/{id}")
    public CustomerProfile update(@PathVariable("id") Long id,  @RequestBody CustomerProfile customerProfile){
        return customerServices.update(id, customerProfile);
    }

    @DeleteMapping("/customer/{id}")
    public void delete(@PathVariable("id") Long Id){
        customerServices.delete(Id);

    }
}
