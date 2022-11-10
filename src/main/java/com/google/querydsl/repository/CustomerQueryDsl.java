package com.google.querydsl.repository;

import com.google.querydsl.entity.Customer;
import com.google.querydsl.service.FilterParams;
import com.querydsl.core.types.Predicate;
import java.util.List;

public interface CustomerQueryDsl {
    List<Customer> findAllQueryDsl(Predicate predicate);
}