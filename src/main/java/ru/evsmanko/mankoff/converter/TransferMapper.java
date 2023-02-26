package ru.evsmanko.mankoff.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.evsmanko.mankoff.dto.TransferDto;
import ru.evsmanko.mankoff.entity.TransferEntity;
import java.util.Objects;

@Component
public class TransferMapper {
    private final ModelMapper mapper = new ModelMapper();
    public TransferEntity toTransfer(TransferDto dto){
        return Objects.isNull(dto) ? null : mapper.map(dto, TransferEntity.class);
    }

    public TransferDto toDto(TransferEntity entity){
        return Objects.isNull(entity) ? null : mapper.map(entity, TransferDto.class);
    }
}
