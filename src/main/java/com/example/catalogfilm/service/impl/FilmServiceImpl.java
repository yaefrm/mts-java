package com.example.catalogfilm.service.impl;

import com.example.catalogfilm.converter.FilmConverter;
import com.example.catalogfilm.dto.FilmDto;
import com.example.catalogfilm.model.Director;
import com.example.catalogfilm.model.Film;
import com.example.catalogfilm.repository.FilmRepository;
import com.example.catalogfilm.service.FilmService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@AllArgsConstructor
@Service

public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;
    private final FilmConverter filmConverter;
    @SneakyThrows({ChangeSetPersister.NotFoundException.class})
    @Override
    public Film getFilm(UUID filmUuid) {
        Optional<Film> filmOptional= filmRepository.findById(filmUuid);
        return filmOptional.orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }

    @Override
    public FilmDto saveFilm(FilmDto film) {
        Film resFilm = filmConverter.convertToEntity(film);
        return filmConverter.convertToDto(filmRepository.save(resFilm));
    }
}
