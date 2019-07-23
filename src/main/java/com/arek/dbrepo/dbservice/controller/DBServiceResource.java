package com.arek.dbrepo.dbservice.controller;

import com.arek.dbrepo.dbservice.model.User;
import com.arek.dbrepo.dbservice.repository.UserRepository;
import com.arek.dbrepo.dbservice.service.UserService;
import org.hibernate.validator.constraints.EAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/db")
public class DBServiceResource {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    public DBServiceResource(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/{email}")
    private List<String> getUsers(@PathVariable("email") final String email) {
        return getUsersByName(email);
    }

    @GetMapping("/all")
    private List<User> getAll(){
        return getAllUser();
    }

    @PostMapping("/adduser")
    private List<String> adduser(@RequestBody final User user){
        userService.saveUser(user);
        return getUsersByName(user.getEmail());
    }


    private List<String> getUsersByName(String email) {
        return userRepository.findByEmail(email).stream().map(User::getLastName).collect(Collectors.toList());
    }


    private List<User> getAllUser() {
        return userRepository.findAll().stream().collect(Collectors.toList());
    }
}
