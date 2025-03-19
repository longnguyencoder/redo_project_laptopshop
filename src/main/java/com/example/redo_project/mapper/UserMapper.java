package com.example.redo_project.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.example.redo_project.domain.User;
import com.example.redo_project.request.UpdateUserRequest;
import com.example.redo_project.request.UserCreateRequest;
import com.example.redo_project.response.UserResponse;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreateRequest request);

    UserResponse toUserResponse(User user);

    void updateUser(@MappingTarget User user, UpdateUserRequest request);
}
