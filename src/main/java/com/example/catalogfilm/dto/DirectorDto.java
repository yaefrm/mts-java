package com.example.catalogfilm.dto;

import com.example.catalogfilm.constants.GenreEnum;
import com.example.catalogfilm.model.Film;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class DirectorDto {
    private UUID uuid;
    private String name;
    private Integer age;
    private String country;
    private List<FilmDto> filmList;
}
