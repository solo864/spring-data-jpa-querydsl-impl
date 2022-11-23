package com.google.querydsl.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(exclude = {"product", "category"})
@ToString(exclude = {"product", "category"})
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "products_categories")
@Entity
public class ProductsCategories extends BaseEntity<Integer> {

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
}