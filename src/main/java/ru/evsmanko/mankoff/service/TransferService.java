package ru.evsmanko.mankoff.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evsmanko.mankoff.converter.TransferMapper;
import ru.evsmanko.mankoff.dto.TransferDto;
import ru.evsmanko.mankoff.repository.TransferRepository;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TransferService {
    private final TransferRepository repo;
    private final TransferMapper transferMapper;

    public TransferDto save(TransferDto dto){
        dto.setTimestamp(Timestamp.from(Instant.now()));
        return transferMapper.toDto(repo.save(transferMapper.toTransfer(dto)));
    }
    public List<TransferDto> findAll(){
        return repo.findAll().stream().map(transferMapper::toDto).collect(Collectors.toList());
    }
    public List<TransferDto> findAllByIdSender(long id){
        return repo.findAllByIdSender(id).stream().map(transferMapper::toDto).collect(Collectors.toList());
    }

}
