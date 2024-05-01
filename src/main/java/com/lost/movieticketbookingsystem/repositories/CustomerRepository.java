package com.lost.movieticketbookingsystem.repositories;

import com.lost.movieticketbookingsystem.models.CustomerProfile;
import org.hibernate.id.enhanced.CustomOptimizerDescriptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerProfile, Long> {
    @Override
    Optional<CustomerProfile> findById(Long id);

    @Override
    CustomerProfile save(CustomerProfile customerProfile);
}
