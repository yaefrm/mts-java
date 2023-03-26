package com.example.catalogfilm.service.impl;

import com.example.catalogfilm.converter.DirectorConverter;
import com.example.catalogfilm.dto.DirectorDto;
import com.example.catalogfilm.model.Director;
import com.example.catalogfilm.repository.DirectorRepository;
import com.example.catalogfilm.service.DirectorService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.hibernate.annotations.NotFound;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@RequiredArgsConstructor
@Service
public class DirectorServiceImpl implements DirectorService {
    private final DirectorRepository directorRepository;
    private final DirectorConverter directorConverter;
    @SneakyThrows({ChangeSetPersister.NotFoundException.class})
    @Override
    public Director getDirector(UUID directorUuid) {
        Optional<Director> directorOptional= directorRepository.findById(directorUuid);
        return directorOptional.orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }

    @Override
    public DirectorDto saveDirector(DirectorDto director) {
        Director newDirector = directorConverter.convertToEntity(director);
        return directorConverter.convertToDto(directorRepository.save(newDirector));
    }
}
