package com.expensemanager.expensemanager.controller;

import com.expensemanager.expensemanager.model.User;
import com.expensemanager.expensemanager.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method= RequestMethod.POST)
    public String  createUser(@RequestBody User user){
        if(userService.existsUserByLogin(user.getLogin())){
            System.out.printf("Login %s already exists", user.getLogin());
            return "/login";
        }else{
            userService.create(user);
            System.out.println(user);
            return "/index";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String updateUser(@RequestBody User user) {
        if(userService.existsUserByLogin(user.getLogin())){
            userService.update(user);
            return "/updated";
        }else{
            System.out.printf("Login %s doesn't exist", user.getLogin());
            System.out.println(user);
            return "/index";
        }
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id")ObjectId id){
        User user = userService.getUserById(id);
        if (user!=null){
            userService.delete(user);
            System.out.printf("User [%s] has been deleted.\n", user);
            return "/deleted";
        }else{
            System.out.printf("User [%s] not found, delete failed.\n", id);
            return "index";
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getAll(){
        return userService.getAll();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getById(@PathVariable("id")ObjectId id){
        return userService.getUserById(id);
    }
}
