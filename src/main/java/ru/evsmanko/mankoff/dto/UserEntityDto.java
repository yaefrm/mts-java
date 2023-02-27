package ru.evsmanko.mankoff.dto;

import lombok.Data;

@Data
public class UserEntityDto {
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private String city;
}
