package com.bd.vendingMachine.controller;

import com.bd.vendingMachine.model.User;
import com.bd.vendingMachine.repository.UserRepository;
import com.bd.vendingMachine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.SocketException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserService service;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getUser(){
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody User obj) throws SocketException {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
