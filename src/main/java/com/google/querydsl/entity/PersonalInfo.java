package com.google.querydsl.entity;

import java.time.LocalDate;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldNameConstants
@Embeddable
public class PersonalInfo {

    private String firstname;
    private String lastname;
    private LocalDate birthDate;
}