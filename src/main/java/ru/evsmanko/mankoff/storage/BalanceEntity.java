package ru.evsmanko.mankoff.storage;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BalanceEntity {
    private double valRub;
    private double valUsd;
    private double valEur;
}