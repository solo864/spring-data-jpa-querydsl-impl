package com.google.querydsl.model;

import lombok.Builder;

@Builder
public record CustomerReadDto(String firstName,
                              String surname,
                              String email) {
}
