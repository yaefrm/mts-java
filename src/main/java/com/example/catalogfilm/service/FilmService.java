package com.example.catalogfilm.service;


import com.example.catalogfilm.dto.FilmDto;
import com.example.catalogfilm.model.Director;
import com.example.catalogfilm.model.Film;

import java.util.UUID;

public interface FilmService {
    Film getFilm(UUID filmUuid);
    FilmDto saveFilm(FilmDto film);//вот тут сайвфильм
}
