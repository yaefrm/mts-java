package com.example.catalogfilm.dto;

import com.example.catalogfilm.constants.GenreEnum;
import lombok.Data;

import java.util.UUID;

@Data
public class FilmDto {
    private UUID uuid;
    private String title;
    private GenreEnum genre;
    private Integer rating;
}
