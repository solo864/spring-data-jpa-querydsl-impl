package com.google.querydsl.entity;

import static javax.persistence.FetchType.LAZY;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(exclude = {"order", "product"})
@ToString(exclude = {"order", "product"})
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "orders_details")
@Entity
public class OrdersDetails extends BaseEntity<Integer> {

    private BigDecimal amount;
    private BigDecimal price;

    @ManyToOne(fetch = LAZY)
    private Order order;

    @ManyToOne(fetch = LAZY)
    private Product product;
}