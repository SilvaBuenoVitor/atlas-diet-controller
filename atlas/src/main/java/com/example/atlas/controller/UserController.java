package com.example.atlas.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.atlas.model.User;
import com.example.atlas.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository repository;

    @PostMapping
    public ResponseEntity<Integer> login(@RequestBody User user, HttpServletRequest request, UriComponentsBuilder builder){
        int answer = repository.login(user);
        if (answer != -1){
            return ResponseEntity.ok().body(answer);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(answer);
    }
}
