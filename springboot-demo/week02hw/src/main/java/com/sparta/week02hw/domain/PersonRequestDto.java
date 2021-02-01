package com.sparta.week02hw.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PersonRequestDto {
    private Long id;
    private String name;
    private int age;
    private String address;
    private String job;
}



