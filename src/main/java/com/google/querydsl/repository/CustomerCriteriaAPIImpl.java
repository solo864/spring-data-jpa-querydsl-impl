package com.google.querydsl.repository;

import com.google.querydsl.entity.Customer;
import com.google.querydsl.service.FilterParams;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class CustomerCriteriaAPIImpl implements CustomerCriteriaAPI {

    private final EntityManager entityManager;


    @Override
    public List<Customer> findAllCriteriaAPI(Predicate predicate, FilterParams params) {
        List<Predicate> predicates = new ArrayList<>();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> criteria = cb.createQuery(Customer.class);
        Root<Customer> customer = criteria.from(Customer.class);
        criteria.select(customer).where(cb.equal(customer.get("firstName"), params.firstName()));
        return entityManager.createQuery(criteria).getResultList();
    }
}
