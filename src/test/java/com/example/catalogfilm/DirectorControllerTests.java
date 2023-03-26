package com.example.catalogfilm;

import com.example.catalogfilm.constants.GenreEnum;
import com.example.catalogfilm.controller.DirectorController;
import com.example.catalogfilm.controller.FilmController;
import com.example.catalogfilm.converter.DirectorConverter;
import com.example.catalogfilm.converter.FilmConverter;
import com.example.catalogfilm.model.Director;
import com.example.catalogfilm.model.Film;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DirectorControllerTests {
    @Autowired
    DirectorController directorController;
    @Autowired
    DirectorConverter directorConverter;

    @Test
    void addDirectorAddedDirector() {
        Film film = new Film();
        String title = "title";
        film.setGenre(GenreEnum.HORROR);
        film.setTitle(title);
        film.setRating(3);

        Director director = new Director();
        director.setAge(15);
        director.setName("name");
        director.setCountry("Moscow");
        director.setFilmList(List.of(film));

        ResponseEntity createdDirector = directorController.addDirector(directorConverter.convertToDto(director));

        assertEquals(HttpStatus.OK, createdDirector.getStatusCode());
    }}
