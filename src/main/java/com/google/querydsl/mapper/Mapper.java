package com.google.querydsl.mapper;

public interface Mapper<F, T> {
    T mapFrom(F object);
}
