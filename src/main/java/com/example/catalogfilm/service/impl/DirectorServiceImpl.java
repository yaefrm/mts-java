package com.example.catalogfilm.service.impl;

import com.example.catalogfilm.converter.DirectorConverter;
import com.example.catalogfilm.dto.DirectorDto;
import com.example.catalogfilm.model.Director;
import com.example.catalogfilm.repository.DirectorRepository;
import com.example.catalogfilm.service.DirectorService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
    @HystrixCommand(fallbackMethod = "getDefaultDirector",
            commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    }
    )
    public Director getDirector(UUID directorUuid) {
        Optional<Director> directorOptional= directorRepository.findById(directorUuid);
        return directorOptional.orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }

    public Director getDefaultDirector(UUID directorUuid) {
        Director defaultDirector = new Director();
        return defaultDirector;
    }

    @Override
    public DirectorDto saveDirector(DirectorDto director) {
        Director newDirector = directorConverter.convertToEntity(director);
        return directorConverter.convertToDto(directorRepository.save(newDirector));
    }
}
