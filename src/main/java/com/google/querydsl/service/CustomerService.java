package com.google.querydsl.service;

import com.google.querydsl.entity.QCustomer;
import com.google.querydsl.mapper.CustomerReadMapper;
import com.google.querydsl.model.CustomerReadDto;
import com.google.querydsl.repository.CustomerRepository;
import com.google.querydsl.repository.QPredicate;
import com.querydsl.core.types.Predicate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerReadMapper customerReadMapper;

    public List<CustomerReadDto> getAll(FilterParams filterParams) {
        Predicate predicate = QPredicate.builder()
                .add(filterParams.firstName(), QCustomer.customer.firstName::eq)
                .add(filterParams.surname(), QCustomer.customer.surname::eq)
                .add(filterParams.email(), QCustomer.customer.email::eq)
                .buildOr();

        return customerRepository.findAll(predicate)
                .stream().map(customerReadMapper::mapFrom)
                .toList();
    }

    public List<CustomerReadDto> getAllQueryDsl(FilterParams filterParams) {
        Predicate predicate = QPredicate.builder()
                .add(filterParams.firstName(), QCustomer.customer.firstName::eq)
                .add(filterParams.surname(), QCustomer.customer.surname::eq)
                .add(filterParams.email(), QCustomer.customer.email::eq)
                .buildOr();
        return customerRepository.findAllQueryDsl(predicate, filterParams)
                .stream().map(customerReadMapper::mapFrom)
                .toList();
    }
}
