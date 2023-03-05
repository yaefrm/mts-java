package com.example.catalogfilm.service;

import com.example.catalogfilm.dto.DirectorDto;
import com.example.catalogfilm.model.Director;

import java.util.UUID;

public interface DirectorService {
    Director getDirector(UUID directorUuid);
    DirectorDto saveDirector(DirectorDto director);
}
