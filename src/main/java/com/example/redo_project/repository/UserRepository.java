package com.example.redo_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.redo_project.domain.User;

public interface UserRepository extends JpaRepository<User, String> {

}
