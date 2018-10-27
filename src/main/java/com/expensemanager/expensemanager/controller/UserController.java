package com.expensemanager.expensemanager.controller;

import com.expensemanager.expensemanager.model.User;
import com.expensemanager.expensemanager.model.Wallet;
import com.expensemanager.expensemanager.service.UserService;
import com.expensemanager.expensemanager.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
