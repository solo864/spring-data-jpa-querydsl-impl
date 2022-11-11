package com.google.querydsl.repository;

import static com.google.querydsl.entity.QCustomer.customer;

import com.google.querydsl.entity.Customer;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import java.util.List;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomerQueryDslImpl implements CustomerQueryDsl {

    private final EntityManager em;

    @Override
    public List<Customer> getAllQueryDsl(Predicate predicate) {
        return new JPAQuery<>(em)
                .select(customer)
                .from(customer)
                .where(predicate)
                .fetch();
    }
}
