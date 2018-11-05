package com.expensemanager.expensemanager.controller;

import com.expensemanager.expensemanager.model.User;
import com.expensemanager.expensemanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/signup")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        if (userService.existsUserByLogin(user.getLogin())) {
            System.out.printf("Login [%s] already exists\n", user.getLogin());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            User createdUser = userService.create(user);
            System.out.printf("New user created: [%s]\n",user);
            return new ResponseEntity<>(createdUser, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        if (userService.existsUserByLogin(user.getLogin())) {
            User updatedUser = userService.update(user);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            System.out.printf("Login [%s] doesn't exist", user.getLogin());
            System.out.println(user);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String id) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            userService.delete(user.get());
            System.out.printf("User [%s] has been deleted.\n", user.get());
            return new ResponseEntity<>("User has been deleted", HttpStatus.OK);
        } else {
            System.out.printf("User [%s] not found, delete failed.\n", id);
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getById(@PathVariable("id") String id) {
        Optional<User> user = userService.getUserById(id);
        return user.isPresent() ? new ResponseEntity<>(user.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
