
package ru.evsmanko.mankoff.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import ru.evsmanko.mankoff.service.AverageUserIncome;
import ru.evsmanko.mankoff.storage.BalanceEntity;


@RestController
@RequestMapping("mankoff")
@RequiredArgsConstructor
public class AverageUserIncomeController {

    @Value("${currency.EUR}")
    private double currencyEUR;

    @Value("${currency.USD}")
    private double currencyUSD;

    private final AverageUserIncome averageCalc;
    @GetMapping("/total_balance")
    public BalanceEntity totalBalanceCalculator(){

        double totalRUB = averageCalc.totalBalance();
        double totalUSD = totalRUB /  currencyUSD;
        double totalEUR = totalRUB /  currencyEUR;

        return new BalanceEntity(totalRUB, totalUSD, totalEUR);
    }
    @GetMapping("/average_income")
    public BalanceEntity averageIncomeCalculator(){

        double totalRUB = averageCalc.averageIncome();
        double totalUSD = totalRUB /  currencyUSD;
        double totalEUR = totalRUB /  currencyEUR;

        return new BalanceEntity(totalRUB, totalUSD, totalEUR);
    }
}