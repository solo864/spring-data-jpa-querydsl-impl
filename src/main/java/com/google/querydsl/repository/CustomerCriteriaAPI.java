package com.google.querydsl.repository;

import com.google.querydsl.entity.Customer;
import com.google.querydsl.service.FilterParams;
import java.util.List;
import javax.persistence.criteria.Predicate;

public interface CustomerCriteriaAPI {
    List<Customer> findAllCriteriaAPI(Predicate predicate, FilterParams params);
}