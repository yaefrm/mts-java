package ru.evsmanko.mankoff.controller;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.evsmanko.mankoff.entity.User;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserDataControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserDataController controller;

    private final static long USER_ID = 4;
    private final static User EXPECTED_USER = new User(USER_ID, "Дмитрий", "Билан", "54235252356");

    @Test
    public void controllerIsNotNullTest() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void userDataResponseMessageTest() {
        String url = "http://localhost:" + port + "/userdata?id=" + USER_ID;
        Gson gson = new GsonBuilder().create();
        assertEquals(gson.toJson(EXPECTED_USER), restTemplate.getForObject(url, String.class));
    }

    @Test
    public void responseSuccessfulTest() {
        String url = "http://localhost:" + port + "/userdata?id=" + USER_ID;
        ResponseEntity<User> response = restTemplate.getForEntity(url, User.class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody().getId(), is(EXPECTED_USER.getId()));
        assertThat(response.getBody().getFirstName(), is(EXPECTED_USER.getFirstName()));
        assertThat(response.getBody().getLastName(), is(EXPECTED_USER.getLastName()));
        assertThat(response.getBody().getPhone(), is(EXPECTED_USER.getPhone()));
    }
}
