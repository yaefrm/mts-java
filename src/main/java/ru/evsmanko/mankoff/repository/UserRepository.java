package ru.evsmanko.mankoff.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.evsmanko.mankoff.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User getUserById(long id);
    User save(User user);
    List<User> findAll();
}
