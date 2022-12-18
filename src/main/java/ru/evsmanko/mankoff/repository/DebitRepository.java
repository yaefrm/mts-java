package ru.evsmanko.mankoff.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.evsmanko.mankoff.entity.Debit;
import ru.evsmanko.mankoff.entity.User;

import java.util.List;

@Repository
public interface DebitRepository extends CrudRepository<Debit, Long> {
    List<Debit> findAllByUserId(long userId);
    Debit save(Debit debit);
}
