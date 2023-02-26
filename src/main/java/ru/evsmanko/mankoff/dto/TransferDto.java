package ru.evsmanko.mankoff.dto;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class TransferDto {
    private Long id;
    private Long idSender;
    private Long idReceiver;
    private Double amount;
    private Timestamp timestamp;
}

