package com.google.querydsl.entity;

import static javax.persistence.FetchType.LAZY;

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
@EqualsAndHashCode(exclude = "bucket")
@ToString(exclude = "product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "buckets_products")
@Entity
public class BucketsProducts extends BaseEntity<Integer> {
    @ManyToOne(fetch = LAZY)
    private Bucket bucket;
    @ManyToOne(fetch = LAZY)
    private Product product;
}