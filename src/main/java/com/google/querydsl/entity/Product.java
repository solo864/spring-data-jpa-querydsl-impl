package com.google.querydsl.entity;

import java.math.BigDecimal;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Product extends BaseEntity<Integer> {

    private String title;
    private BigDecimal price;
}