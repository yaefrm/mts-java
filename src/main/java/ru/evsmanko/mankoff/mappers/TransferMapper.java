package ru.evsmanko.mankoff.mappers;

import org.mapstruct.Mapper;
import ru.evsmanko.mankoff.dto.TransferDto;
import ru.evsmanko.mankoff.entity.TransferEntity;

@Mapper(componentModel = "spring")
public interface TransferMapper {
    TransferDto toDto(TransferEntity transferEntity);
    TransferEntity toTransfer(TransferDto transferDto);
}
