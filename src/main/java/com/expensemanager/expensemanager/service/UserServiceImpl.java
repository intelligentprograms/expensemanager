package com.expensemanager.expensemanager.service;

import com.expensemanager.expensemanager.model.User;
import com.expensemanager.expensemanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    //create
    public User create(User user){
        return userRepository.save(user);
    }

    //update
    public User update(User user){
        User oldUser = userRepository.findById(Integer.parseInt(user.getId()));

        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setLogin(user.getLogin());
        user.setPassword(user.getPassword());
        user.setDescription(user.getDescription());
        user.setEmail(user.getEmail());
        user.setGroupId(user.getGroupId());
        user.setCountryId(user.getCountryId());
        user.setLanguageId(user.getLanguageId());
        user.setDateOfBirth(user.getDateOfBirth());
        user.setRegistrationDate(user.getRegistrationDate());
        return userRepository.save(user);
    }

    //delete
    public void delete(String id){
        User user = userRepository.findById(Integer.parseInt(id));
        userRepository.delete(user);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    @Override
    public boolean existsUserByLogin(String login) {
        return userRepository.existsUserByLogin(login);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
