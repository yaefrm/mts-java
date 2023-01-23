package ru.evsmanko.mankoff.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

import ru.evsmanko.mankoff.entity.User;
import ru.evsmanko.mankoff.repository.UserRepository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class ExportUserDataServiceTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private ExportUserDataService exportUserDataService;

    private static final long USER_ID = 1;
    private static final String FILE_PATH = "src/main/java/jsons/user.json";

    @Test
    @DisplayName("Testing service of export user data to json")
    public void exportingUserDataToJsonTest() throws IOException {
        User user = new User(USER_ID, "Max", "Volkov", "79773617425");
        when(userRepository.getUserById(USER_ID)).thenReturn(user);
        exportUserDataService.exportUserDataById(USER_ID);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        StringBuilder actualJson = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            while (reader.ready()) {
                actualJson.append(reader.readLine()).append('\n');
            }
        }

        assertEquals(gson.toJson(user), actualJson.toString().trim());
    }

}
