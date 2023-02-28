package com.example.catalogfilm.controller;

import com.example.catalogfilm.model.Director;
import com.example.catalogfilm.model.Film;
import com.example.catalogfilm.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/film")
public class FilmController {

    private final FilmService filmService;

    @PostMapping
    public ResponseEntity<?> addFilm(@RequestBody Film film) {
        Film resultFilm = filmService.saveFilm(film);
        return ResponseEntity.ok(resultFilm);
    }

    @GetMapping
    public ResponseEntity<?> getFilm(@RequestParam("filmUuid") UUID filmUuid) {
        Film film = filmService.getFilm(filmUuid);
        return ResponseEntity.ok(film);
    }

}

