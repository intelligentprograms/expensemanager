package com.expensemanager.expensemanager.controller;

import com.expensemanager.expensemanager.model.User;
import com.expensemanager.expensemanager.model.Wallet;
import com.expensemanager.expensemanager.service.UserService;
import com.expensemanager.expensemanager.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/wallet")
public class WalletController {

    @Autowired
    WalletService walletService;
    @Autowired
    UserService userService;


    @RequestMapping(value = "/login",method= RequestMethod.POST)
    public String  create(@RequestBody Wallet wallet, String username){
        User user = userService.findByUsername(username);

        if(user.getWallet().contains(wallet)){
            System.out.println("You already have this wallet!");
            return "/login";
        }
        else{
            walletService.createWallet(wallet);
            user.getWallet().add(wallet);
            return "/index";
        }
    }
}
