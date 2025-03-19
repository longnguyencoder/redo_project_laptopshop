package com.example.redo_project.service;

import com.example.redo_project.RedoProjectApplication;
import com.example.redo_project.controller.UserController;
import com.example.redo_project.domain.User;
import com.example.redo_project.exception.AppException;
import com.example.redo_project.exception.ErrorCode;
import com.example.redo_project.mapper.UserMapperImpl;
import com.example.redo_project.repository.UserRepository;
import com.example.redo_project.request.UpdateUserRequest;
import com.example.redo_project.request.UserCreateRequest;
import com.example.redo_project.response.UserResponse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserMapperImpl userMapperImpl;

    private UserRepository userRepository;

    public UserService(UserRepository userRepository, UserMapperImpl userMapperImpl) {
        this.userRepository = userRepository;
        this.userMapperImpl = userMapperImpl;

    }

    public List<UserResponse> getUsers() {
        return userRepository.findAll().stream()
                .map(userMapperImpl::toUserResponse).toList();
    }

    public UserResponse createUser(UserCreateRequest request) {
        if (userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTS);

        User user = userMapperImpl.toUser(request);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return userMapperImpl.toUserResponse(userRepository.save(user));
    }

    // update user
    public UserResponse updateUser(String userId, UpdateUserRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXITS));

        userMapperImpl.updateUser(user, request);

        return userMapperImpl.toUserResponse(userRepository.save(user));
    }

    public UserResponse getUserById(String id) {
        return userMapperImpl.toUserResponse(userRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXITS)));
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
