package com.expensemanager.expensemanager.service;

import com.expensemanager.expensemanager.model.User;
import com.expensemanager.expensemanager.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        User oldUser = userRepository.findById(user.getId());

        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        oldUser.setLogin(user.getLogin());
        oldUser.setPassword(user.getPassword());
        oldUser.setDescription(user.getDescription());
        oldUser.setEmail(user.getEmail());
        oldUser.setGroupId(user.getGroupId());
        oldUser.setCountryId(user.getCountryId());
        oldUser.setLanguageId(user.getLanguageId());
        oldUser.setDateOfBirth(user.getDateOfBirth());
        return userRepository.save(oldUser);
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
    public User getUserById(ObjectId id) {
        return userRepository.findById(id);
    }

}
