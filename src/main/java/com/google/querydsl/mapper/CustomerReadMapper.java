package com.google.querydsl.mapper;

import com.google.querydsl.entity.Customer;
import com.google.querydsl.model.CustomerReadDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerReadMapper implements Mapper<Customer, CustomerReadDto> {
    @Override
    public CustomerReadDto mapFrom(Customer object) {
        return CustomerReadDto.builder()
                .firstName(object.getFirstName())
                .email(object.getEmail())
                .surname(object.getSurname())
                .build();
    }
}
