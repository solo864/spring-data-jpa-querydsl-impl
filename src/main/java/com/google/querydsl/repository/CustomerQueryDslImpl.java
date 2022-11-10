package com.google.querydsl.repository;

import com.google.querydsl.entity.Customer;
import com.google.querydsl.entity.QCustomer;
import com.google.querydsl.service.FilterParams;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import java.util.List;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomerQueryDslImpl implements CustomerQueryDsl {

    private final EntityManager em;

    @Override
    public List<Customer> findAllQueryDsl(Predicate predicate) {
        return new JPAQuery<>(em)
                .select(QCustomer.customer)
                .from(QCustomer.customer)
                .where(predicate)
                .fetch();
    }
}