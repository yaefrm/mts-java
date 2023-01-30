package ru.evsmanko.mankoff.service;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import ru.evsmanko.mankoff.entity.Credit;
import ru.evsmanko.mankoff.entity.Debit;
import ru.evsmanko.mankoff.entity.User;
import ru.evsmanko.mankoff.repository.CreditRepository;
import ru.evsmanko.mankoff.repository.DebitRepository;
import ru.evsmanko.mankoff.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DebtCalculator {
    private final UserRepository userRepository;

    private final DebitRepository debitRepository;

    private final CreditRepository creditRepository;

    public double creditCheck(long id){
        val credits = creditRepository.findAllByUserId(id);
        return credits.stream().mapToDouble(Credit::getAmount).sum();
    }

    public double debitCheck(long id){
        val debits = debitRepository.findAllByUserId(id);
        return debits.stream().mapToDouble(Debit::getAmount).sum();
    }

    public List<User> usersWithCreditMoreThanDebit(){
        val allUsers =  userRepository.findAll();
        return allUsers.stream().filter(user ->
             creditCheck(user.getId()) > debitCheck(user.getId())
        ).collect(Collectors.toList());
    }
}
