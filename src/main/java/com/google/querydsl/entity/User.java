package com.google.querydsl.entity;


import static javax.persistence.EnumType.STRING;

import az.online.shop.model.Role;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(exclude = "bucket")
@ToString(exclude = "bucket")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
@Entity
public class User extends BaseEntity<Integer> {
    private String username;
    private String email;
    private String password;
    private String image;
    @Embedded
    private PersonalInfo personalInfo;
    @Enumerated(STRING)
    private Role role;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private Bucket bucket;
}