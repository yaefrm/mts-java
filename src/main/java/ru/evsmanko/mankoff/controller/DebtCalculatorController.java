package ru.evsmanko.mankoff.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.evsmanko.mankoff.entity.User;
import ru.evsmanko.mankoff.service.DebtCalculator;

import java.util.List;

@RestController
@RequestMapping("mankoff")
@RequiredArgsConstructor
public class DebtCalculatorController {
    private final DebtCalculator debtCalculator;
    @GetMapping("/debt/{id}")
    public double debtCalculator(@PathVariable Long id){
        return debtCalculator.creditCheck(id);
    }
    @GetMapping("/listdebt")
    public List<User> usersWithCreditMoreThanDebit(){
        return debtCalculator.usersWithCreditMoreThanDebit();
    }
}
