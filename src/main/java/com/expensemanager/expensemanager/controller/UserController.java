package com.expensemanager.expensemanager.controller;

import com.expensemanager.expensemanager.model.User;
import com.expensemanager.expensemanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method= RequestMethod.POST)
    public String  create(@RequestBody User user){
        if(userService.existsUserByLogin(user.getLogin())){
            System.out.printf("Login %s already exists", user.getLogin());
            return "/login";
        }else{
            userService.create(user);
            System.out.println(user);
            return "/index";
        }
    }

    @RequestMapping(value = "/update-user", method = RequestMethod.PUT)
    public String updateUser(@RequestBody User user) {
        if(userService.existsUserByLogin(user.getLogin())){
            userService.update(user);
            return "/updated";
        }else{
            System.out.printf("Login %s doesn't exist", user.getLogin());
            System.out.println(user);
            return "/updated";
        }
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getAll(){
        return userService.getAll();
    }
}
