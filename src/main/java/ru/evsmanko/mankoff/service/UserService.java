package ru.evsmanko.mankoff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evsmanko.mankoff.dto.UserEntityDto;
import ru.evsmanko.mankoff.entity.UserEntity;
import ru.evsmanko.mankoff.mapper.UserMapper;
import ru.evsmanko.mankoff.repository.UserEntityRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserEntityRepository userEntityRepository;

    private final UserMapper userMapper;

    public Optional<UserEntityDto> getById(long id) {
        Optional<UserEntity> userEntity = userEntityRepository.getUserEntityById(id);

        if (userEntity.isEmpty())
            return Optional.empty();

        return Optional.of(userMapper.toDTO(userEntity.get()));
    }

    public Optional<UserEntityDto> save(UserEntityDto userDto) {
        Optional<UserEntity> userEntity = userEntityRepository.save(userMapper.toEntity(userDto));

        if (userEntity.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(userMapper.toDTO(userEntity.get()));
    }
}
