package com.example.redo_project.service;

import com.example.redo_project.RedoProjectApplication;
import com.example.redo_project.controller.UserController;
import com.example.redo_project.domain.User;
import com.example.redo_project.repository.UserRepository;
import com.example.redo_project.request.UpdateUserRequest;
import com.example.redo_project.request.UserCreateRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public String handHelloWord() {
        return "hello word";
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User createUser(UserCreateRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setDob(request.getDob());
        return userRepository.save(user);
    }

    public User UpdateUser(String userId, UpdateUserRequest request) {
        User user = getUserById(userId);

        user.setPassword(request.getPassword());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setDob(request.getDob());
        return userRepository.save(user);
    }

    public User getUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("user not found")); // nếu tìm thấy user thì trả về
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
