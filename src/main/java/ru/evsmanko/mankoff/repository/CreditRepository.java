package ru.evsmanko.mankoff.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.evsmanko.mankoff.entity.Credit;
import ru.evsmanko.mankoff.entity.Debit;

import java.util.List;

@Repository
public interface CreditRepository extends CrudRepository<Credit, Long> {
    List<Credit> findAllByUserId(long userId);
    Credit save(Credit debit);
}
