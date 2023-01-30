package ru.evsmanko.mankoff.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TotalBalance {
    private double RUB;
    private double USD;
    private double EUR;
}
