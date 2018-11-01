package com.expensemanager.expensemanager.service;

import com.expensemanager.expensemanager.model.User;
import org.bson.types.ObjectId;

import java.util.List;

public interface UserService {
    User create(User user);
    User update(User user);
    void delete(User user);
    List<User> getAll();
    boolean existsUserByLogin(String login);
    User findByLogin(String login);
    User getUserById(ObjectId id);
}
