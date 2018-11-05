package com.expensemanager.expensemanager.service;

import com.expensemanager.expensemanager.model.User;
import com.expensemanager.expensemanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    //create
    public User create(User user) {
        return userRepository.save(user);
    }

    //update
    public User update(User user) {
        Optional<User> oldUser = userRepository.findById(user.getId());
        User _oldUser = oldUser.get();
        _oldUser.setFirstName(user.getFirstName());
        _oldUser.setLastName(user.getLastName());
        _oldUser.setLogin(user.getLogin());
        _oldUser.setPassword(user.getPassword());
        _oldUser.setDescription(user.getDescription());
        _oldUser.setEmail(user.getEmail());
        _oldUser.setGroupId(user.getGroupId());
        _oldUser.setCountryId(user.getCountryId());
        _oldUser.setLanguageId(user.getLanguageId());
        _oldUser.setDateOfBirth(user.getDateOfBirth());
        return userRepository.save(_oldUser);

    }

    //delete
    public void delete(User user) {
        if (userRepository.existsUserByLogin(user.getLogin())) {
            userRepository.delete(user);
        }
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean existsUserByLogin(String login) {
        return userRepository.existsUserByLogin(login);
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

}
