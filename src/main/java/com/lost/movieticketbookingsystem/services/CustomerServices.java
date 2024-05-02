package com.lost.movieticketbookingsystem.services;

import com.lost.movieticketbookingsystem.exceptions.CustomerNotFoundException;
import com.lost.movieticketbookingsystem.models.CustomerProfile;
import com.lost.movieticketbookingsystem.repositories.CustomerRepository;
import org.hibernate.id.enhanced.CustomOptimizerDescriptor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service("customerServices")
public class CustomerServices implements CustomerServ {
    CustomerRepository customerRepository;

    public CustomerServices(@Qualifier("customerRepository") CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public CustomerProfile getById(Long id){
        Optional<CustomerProfile> customerProfile1 = customerRepository.findById(id);
        if(customerProfile1.isEmpty()){
            throw new CustomerNotFoundException("Customer not found");
        }

        return customerProfile1.get();
    }

    public List<CustomerProfile> getAll(){
        return customerRepository.findAll();
    }
    public CustomerProfile create(CustomerProfile customerProfile){
        return customerRepository.save(customerProfile);
    }

    public CustomerProfile update(Long Id, CustomerProfile customerProfile){
        CustomerProfile customerProfile1 = customerRepository.findById(Id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));

        customerProfile1.setName(customerProfile.getName());
        customerProfile1.setEmail(customerProfile.getEmail());
        customerProfile1.setContact_no(customerProfile.getContact_no());

        customerRepository.save(customerProfile1);

        return customerProfile1;
    }

    public void delete(Long Id){
        customerRepository.deleteById(Id);
    }




}
