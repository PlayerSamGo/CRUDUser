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
        //JUST ACTIVE USERS
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/{id}") //Specify REST method POST
    public ResponseEntity<User> findById(@PathVariable("id") Integer id){
        return userService.findById(id)
                .map(ResponseEntity::ok) //Response 200 status code plus object user created
                .orElseGet(()-> ResponseEntity.notFound().build()); //Response 404 status code
    }

    @PostMapping //Specify REST method POST
    public ResponseEntity<User> create(@RequestBody User user){
        user.setStatus("ACTIVE"); //Set status by default Active
        return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED); //Return object with 201 status code
    }

    @PutMapping //Specify REST method PUT
    public ResponseEntity<User> update(@RequestBody User user){
        return userService.findById(user.getId())
                .map(userFound -> ResponseEntity.ok(userService.update(user))) //Response 200 status code with object user updated
                .orElseGet(()->ResponseEntity.notFound().build()); //Response 404 status code
    }

    @DeleteMapping("/{id}") //Specify REST method DELETE
    public ResponseEntity<User> delete(@PathVariable("id") Integer id){
        return userService.findById(id)
                .map(userFound ->{
                    //if (userFound.getStatus().equals("ACTIVE")) {
                    userService.delete(id); //Delete user found
                    return ResponseEntity.ok(userFound); //Response 200 status code with object user deleted
                })
                .orElseGet(()->ResponseEntity.notFound().build()); //Response 404 status code
    }
}
