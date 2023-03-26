package com.example.catalogfilm.controller;


import com.example.catalogfilm.service.ThreadService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/thread")
public class ThreadController {

    ThreadService threadService;

    @GetMapping
    public ResponseEntity<String> getThread(){
        threadService.start();
        return ResponseEntity.ok("DONE! Lets check logs");
    }
}
