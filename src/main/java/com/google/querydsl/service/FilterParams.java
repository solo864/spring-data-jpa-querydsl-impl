package com.google.querydsl.service;

import lombok.Builder;

@Builder
public record FilterParams(String firstName,
                           String email,
                           String surname) {
}