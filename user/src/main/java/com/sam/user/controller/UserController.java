package com.sam.user.controller;

import com.sam.user.model.User;
import com.sam.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController //Specify REST controller
@RequestMapping("/api/user") //Set up suburl to hit
public class UserController {

    @Autowired //Link interfaces or clases
    private UserService userService;

    @GetMapping //Specify REST method GET
    public ResponseEntity<List <User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping //Specify REST method POST
    public ResponseEntity<User> create(@RequestBody User user){
        user.setStatus("ACTIVE"); //Set status by default Active
        return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED); //Return object with 201 status code
    }
}
