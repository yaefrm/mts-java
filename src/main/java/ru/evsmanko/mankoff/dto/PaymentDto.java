package ru.evsmanko.mankoff.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class PaymentDto {
    private Long id;
    private Long buyerId;
    private Integer MCCCode;
    private Double sum;
    private Timestamp timestamp;
}
