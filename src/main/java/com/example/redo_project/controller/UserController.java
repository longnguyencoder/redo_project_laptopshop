package com.example.redo_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.redo_project.domain.User;
import com.example.redo_project.request.UpdateUserRequest;
import com.example.redo_project.request.UserCreateRequest;
import com.example.redo_project.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    List<User> getUser() {
        return userService.getUsers();
    }

    @PostMapping("/create")
    User createUser(@RequestBody UserCreateRequest request) {

        return userService.createUser(request);
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") String userId) {

        return userService.getUserById(userId);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "user has been deleted";
    }

    @PutMapping("/{userId}")
    User UpdateUser(@PathVariable String userId, @RequestBody UpdateUserRequest request) {

        return userService.UpdateUser(userId, request);
    }

}
