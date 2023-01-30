package ru.evsmanko.mankoff.service;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ru.evsmanko.mankoff.entity.User;
import ru.evsmanko.mankoff.repository.UserRepository;
import ru.evsmanko.mankoff.configuration.UserProperties;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;


@Service
public class ExportUserDataService {

    @Value(value = "${app.filePath}")
    private UserProperties userProperties;

    private final UserRepository userRepository;

    @Autowired
    public ExportUserDataService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * This method export user data to json format using Gson util
     *
     * @param id is ID that the user is being searched for
     * @return User Method returns object User found by ID
     */
    public User exportUserDataById(long id) throws IOException {
        User userById = userRepository.getUserById(id);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        try (FileWriter writer = new FileWriter(userProperties.getFilePath())) {
            writer.write(gson.toJson(userById));
        }
        return userById;
    }

}
