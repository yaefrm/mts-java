package ru.evsmanko.mankoff.service;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.evsmanko.mankoff.entity.Debit;
import ru.evsmanko.mankoff.entity.User;
import ru.evsmanko.mankoff.repository.DebitRepository;
import ru.evsmanko.mankoff.repository.UserRepository;

import java.util.List;

@Service
public class AverageUserIncome {
    private UserRepository userRepo;

    private DebitRepository debitRepo;


    @Autowired
    public void setUserRepo(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Autowired
    public void setDebitRepo(DebitRepository debitRepo) {
        this.debitRepo = debitRepo;
    }

    public double totalBalance() {
        val debits = (List<Debit>) debitRepo.findAll();
        return debits.stream().mapToDouble(Debit::getAmount).sum();
    }

    public double totalUsers() {
        val users = (List<User>) userRepo.findAll();
        return users.size();
    }

    public double averageIncome() {
        val average = totalBalance() / totalUsers();
        return average;
    }

}

