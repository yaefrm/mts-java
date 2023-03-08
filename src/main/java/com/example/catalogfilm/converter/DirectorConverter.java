package com.example.catalogfilm.converter;

import com.example.catalogfilm.dto.DirectorDto;
import com.example.catalogfilm.model.Director;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class DirectorConverter {
    private final ModelMapper modelMapper;

    public DirectorConverter() {
        modelMapper = new ModelMapper();
    }

    public DirectorDto convertToDto(Director mcc) {
        return modelMapper.map(mcc, DirectorDto.class);
    }

    public Director convertToEntity(DirectorDto mcc){
        return modelMapper.map(mcc, Director.class);
    }
}
