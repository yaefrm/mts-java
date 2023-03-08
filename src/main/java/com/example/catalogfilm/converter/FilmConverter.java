package com.example.catalogfilm.converter;

import com.example.catalogfilm.dto.FilmDto;
import com.example.catalogfilm.model.Film;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class FilmConverter {

    private final ModelMapper modelMapper;

    public FilmConverter() {
        modelMapper = new ModelMapper();
    }

    public FilmDto convertToDto(Film mcc) {
        return modelMapper.map(mcc, FilmDto.class);
    }

    public Film convertToEntity(FilmDto mcc){
        return modelMapper.map(mcc, Film.class);
    }
}
