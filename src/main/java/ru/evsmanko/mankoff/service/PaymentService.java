package ru.evsmanko.mankoff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evsmanko.mankoff.converter.PaymentMapper;
import ru.evsmanko.mankoff.dto.PaymentDto;
import ru.evsmanko.mankoff.repository.PaymentRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository repository;
    private final PaymentMapper mapper;

    public List<PaymentDto> findPaymentsByBuyerId(long buyerId) {
        return repository.findPaymentEntitiesByBuyerId(buyerId)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public PaymentDto save(PaymentDto dto) {
        dto.setTimestamp(new Timestamp(System.currentTimeMillis()));
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }
}
