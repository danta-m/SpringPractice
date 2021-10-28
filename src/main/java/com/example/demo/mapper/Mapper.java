package com.example.demo.mapper;

public interface Mapper<T, K> {
    T mapToDto(K value);
}
