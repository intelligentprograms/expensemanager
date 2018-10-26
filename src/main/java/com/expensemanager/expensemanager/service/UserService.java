package com.expensemanager.expensemanager.service;

import com.expensemanager.expensemanager.model.User;
import java.util.List;

public interface UserService {
    User create(User user);
    User update(User user);
    void delete(String id);
    List<User> getAll();
    boolean existsUserByLogin(String login);
}
