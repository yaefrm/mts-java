package ru.evsmanko.mankoff.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import ru.evsmanko.mankoff.dto.PaymentDto;
import ru.evsmanko.mankoff.entity.PaymentEntity;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PaymentMapper {
    PaymentDto toDto(PaymentEntity entity);

    PaymentEntity toEntity(PaymentDto dto);
}
