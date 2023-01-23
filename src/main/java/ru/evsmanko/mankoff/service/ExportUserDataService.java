package ru.evsmanko.mankoff.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import ru.evsmanko.mankoff.entity.User;
import ru.evsmanko.mankoff.repository.UserRepository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class ExportUserDataService {
    private static final String FILE_PATH = "src/main/java/jsons/user.json";
    private final UserRepository userRepository;

    @Autowired
    public ExportUserDataService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * This method export user data to json format using Gson util
     *
     * @param id is ID that the user is being searched for
     */
    public void exportUserDataById(long id) throws IOException {
        User userById = userRepository.getUserById(id);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            writer.write(gson.toJson(userById));
        }
    }

}
