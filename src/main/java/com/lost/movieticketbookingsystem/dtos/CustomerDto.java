package com.lost.movieticketbookingsystem.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {
    Long id;
    private String name;
    private String contact_no;
    private String email;
}
