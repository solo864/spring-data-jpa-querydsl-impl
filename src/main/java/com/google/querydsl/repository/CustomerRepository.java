package com.google.querydsl.repository;

import com.google.querydsl.entity.Customer;
import com.querydsl.core.types.Predicate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CustomerRepository extends JpaRepository<Customer, Integer>, QuerydslPredicateExecutor<Customer> , CustomerQueryDsl, CustomerCriteriaAPI{
    List<Customer> findAll(Predicate predicate);
}
