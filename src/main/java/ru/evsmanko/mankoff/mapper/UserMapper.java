package ru.evsmanko.mankoff.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.evsmanko.mankoff.dto.UserEntityDto;
import ru.evsmanko.mankoff.entity.UserEntity;

@Component
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {
    UserEntityDto toDTO(UserEntity userEntity);
    UserEntity toEntity(UserEntityDto userDto);
}
