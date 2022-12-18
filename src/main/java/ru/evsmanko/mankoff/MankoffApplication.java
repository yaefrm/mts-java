package ru.evsmanko.mankoff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.evsmanko.mankoff.repository.UserRepository;

@SpringBootApplication
public class MankoffApplication {

    public static void main(String[] args) {
        SpringApplication.run(MankoffApplication.class, args);
    }

}
