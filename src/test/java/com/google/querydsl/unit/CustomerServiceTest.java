package com.google.querydsl.unit;

import static org.mockito.Mockito.when;

import com.google.querydsl.entity.Customer;
import com.google.querydsl.entity.QCustomer;
import com.google.querydsl.mapper.CustomerReadMapper;
import com.google.querydsl.model.CustomerReadDto;
import com.google.querydsl.model.Role;
import com.google.querydsl.repository.CustomerRepository;
import com.google.querydsl.repository.QPredicate;
import com.google.querydsl.service.CustomerService;
import com.google.querydsl.service.FilterParams;
import com.querydsl.core.types.Predicate;
import java.time.LocalDate;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private CustomerReadMapper customerReadMapper;
    @InjectMocks
    private CustomerService customerService;


    @Test
    void queryDsl1stWay() {
        FilterParams params = FilterParams.builder().build();
        Predicate predicate = QPredicate.builder().add(params.firstName(), QCustomer.customer.firstName::eq)
                .add(params.surname(), QCustomer.customer.surname::eq)
                .add(params.email(), QCustomer.customer.email::eq)
                .build();
        var customerReadDto = List.of(new CustomerReadDto("test", "test", "test"));
        var customers = List.of(new Customer(null, "test", "test", "test", "test", LocalDate.now(), Role.ADMIN, null));

        when(customerRepository.findAll(predicate)).thenReturn(customers);
        when(customerReadMapper.mapFrom(customers.get(0))).thenReturn(customerReadDto.get(0));

        List<CustomerReadDto> actualResult = customerService.getAll(params);

        Assertions.assertThat(actualResult).hasSize(1);

        List<String> names = actualResult.stream().map(CustomerReadDto::firstName).toList();
        Assertions.assertThat(names).containsExactlyInAnyOrder("test");
    }

    @Test
    void queryDsl2ndWay() {
        FilterParams params = FilterParams.builder().build();
        Predicate predicate = QPredicate.builder().add(params.firstName(), QCustomer.customer.firstName::eq)
                .add(params.surname(), QCustomer.customer.surname::eq)
                .add(params.email(), QCustomer.customer.email::eq)
                .build();
        var customerReadDto = List.of(new CustomerReadDto("test", "test", "test"));
        var customers = List.of(new Customer(null, "test", "test", "test", "test", LocalDate.now(), Role.ADMIN, null));

        when(customerRepository.findAll(predicate)).thenReturn(customers);
        when(customerReadMapper.mapFrom(customers.get(0))).thenReturn(customerReadDto.get(0));

        List<CustomerReadDto> actualResult = customerService.getAll(params);

        Assertions.assertThat(actualResult).hasSize(1);

        List<String> names = actualResult.stream().map(CustomerReadDto::firstName).toList();
        Assertions.assertThat(names).containsExactlyInAnyOrder("test");
    }
}