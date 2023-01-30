package ru.evsmanko.mankoff.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ru.evsmanko.mankoff.entity.User;
import ru.evsmanko.mankoff.service.ExportUserDataService;

import java.io.IOException;


@RestController
@RequestMapping("userdata")
public class UserDataController {

    private final ExportUserDataService exportUserDataService;

    @Autowired
    public UserDataController(ExportUserDataService exportUserDataService) {
        this.exportUserDataService = exportUserDataService;
    }

    @GetMapping
    public ResponseEntity<User> userData(@RequestParam long id) throws IOException {
        User user = exportUserDataService.exportUserDataById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
