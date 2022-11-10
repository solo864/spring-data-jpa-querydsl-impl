package com.google.querydsl.integration.service;


import static org.assertj.core.api.Assertions.assertThat;

import com.google.querydsl.annotation.IT;
import com.google.querydsl.model.CustomerReadDto;
import com.google.querydsl.service.CustomerService;
import com.google.querydsl.service.FilterParams;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

@IT
@RequiredArgsConstructor
public class CustomerServiceIT {

    private final CustomerService customerService;

    @Test
    void getAllWithPredicate1stWay() {
        FilterParams params = FilterParams.builder()
                .email("findlay@gmail.com")
                .firstName("Isobelle")
                .surname("Abida")
                .build();

        List<CustomerReadDto> actualResult = customerService.getAll(params);
        assertThat(actualResult).hasSize(3);

        List<String> names = actualResult.stream().map(CustomerReadDto::firstName).toList();
        assertThat(names).containsExactlyInAnyOrder("Isobelle", "Findlay", "Cleveland");
    }

    @Test
    void getAllWithPredicate2ndWay() {
        FilterParams params = FilterParams.builder()
                .email("findlay@gmail.com")
                .firstName("Isobelle")
                .surname("Abida")
                .build();

        List<CustomerReadDto> actualResult = customerService.getAllQueryDsl(params);
        assertThat(actualResult).hasSize(3);

        List<String> names = actualResult.stream().map(CustomerReadDto::firstName).toList();
        assertThat(names).containsExactlyInAnyOrder("Isobelle", "Findlay", "Cleveland");
    }
}