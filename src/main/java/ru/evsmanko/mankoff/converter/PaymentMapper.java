package ru.evsmanko.mankoff.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.evsmanko.mankoff.dto.PaymentDto;
import ru.evsmanko.mankoff.entity.PaymentEntity;

@Component
public class PaymentMapper {
    private final ModelMapper mapper = new ModelMapper();

    public PaymentDto toDto(PaymentEntity entity) {
        return mapper.map(entity, PaymentDto.class);
    }

    public PaymentEntity toEntity(PaymentDto dto) {
        return mapper.map(dto, PaymentEntity.class);
    }
}
