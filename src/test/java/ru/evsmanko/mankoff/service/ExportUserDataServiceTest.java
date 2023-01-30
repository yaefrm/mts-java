package ru.evsmanko.mankoff.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.evsmanko.mankoff.entity.User;
import org.junit.jupiter.api.Assertions;


@SpringBootTest
public class ExportUserDataServiceTest {

    @Value(value = "${app.filePath}")
    private String filePath;

    private final ExportUserDataService exportUserDataService;

    @Autowired
    public ExportUserDataServiceTest(ExportUserDataService exportUserDataService) {
        this.exportUserDataService = exportUserDataService;
    }

    @Test
    @DisplayName("Testing service of export user data to json")
    public void testExport() throws IOException {
        long userId = 4;
        User user = new User(userId, "Дмитрий", "Билан", "54235252356");
        exportUserDataService.exportUserDataById(userId);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        StringBuilder userJsonActual = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.ready()) {
                userJsonActual.append(reader.readLine()).append('\n');
            }
        }

        Assertions.assertEquals(gson.toJson(user), userJsonActual.toString().trim());
    }

}
