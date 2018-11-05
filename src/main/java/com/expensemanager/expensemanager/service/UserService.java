package com.expensemanager.expensemanager.service;

import com.expensemanager.expensemanager.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User create(User user);
    User update(User user);
    void delete(User user);
    List<User> getAll();
    boolean existsUserByLogin(String login);
    User findByLogin(String login);
    Optional<User> getUserById(String id);
}
