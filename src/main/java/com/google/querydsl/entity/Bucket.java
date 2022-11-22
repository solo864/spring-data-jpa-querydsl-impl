package com.google.querydsl.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(exclude = "user")
@ToString(exclude = "user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Bucket extends BaseEntity<Integer> {
    @OneToOne(fetch = FetchType.LAZY)
    private User user;
}