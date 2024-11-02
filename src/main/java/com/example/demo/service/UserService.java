package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    void saveUser(User user);

    User getById(long id);

    List<User> getAllUsers();

    void updateUser(User user);

    void deleteUser(long id);

    User generateRandomUser();
}


