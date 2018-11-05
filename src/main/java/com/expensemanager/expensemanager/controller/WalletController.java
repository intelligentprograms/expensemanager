package com.expensemanager.expensemanager.controller;

import com.expensemanager.expensemanager.model.Wallet;
import com.expensemanager.expensemanager.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/wallet")
public class WalletController {

    @Autowired
    WalletService walletService;
//    @Autowired
//    UserService userService;


    /*@RequestMapping(value = "/login",method= RequestMethod.POST)
    public String  create(@RequestBody Wallet wallet, String login){
        User user = userService.findByLogin(login);

        if(user.getWallet().contains(wallet)){
            System.out.println("You already have this wallet!");
            return "/login";
        }
        else{
            walletService.create(wallet);
            user.getWallet().add(wallet);
            return "/index";
        }
    }*/

    @PostMapping(value = "/create")
    public ResponseEntity<Wallet> createWallet(@RequestBody Wallet wallet) {

        if (walletService.existsByName(wallet.getName())){
            System.out.printf("Wallet with name [%s] already exists\n", wallet.getName());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            Wallet createdWallet = walletService.create(wallet);
            System.out.printf("Created wallet [%s]\n",createdWallet);
            return new ResponseEntity<>(createdWallet, HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteWallet(@PathVariable("id") String id) {
        Optional<Wallet> wallet = walletService.getWalletById(id);
        if (wallet.isPresent()) {
            walletService.delete(wallet.get());
            System.out.printf("Wallet [%s] has been deleted.\n", wallet.get());
            return new ResponseEntity<>("Wallet has been deleted", HttpStatus.OK);
        } else {
            System.out.printf("Wallet [%s] not found, delete failed.\n", id);
            return new ResponseEntity<>("Wallet not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Wallet> updateWallet(@RequestBody Wallet wallet) {
        if (walletService.existsByIdAndName(wallet.getId(), wallet.getName())) {
            Wallet updatedWallet = walletService.update(wallet);
            Optional<Wallet> oldWallet = walletService.getWalletById(wallet.getId());
            System.out.printf("Old wallet:\t [%s]\nNew wallet:\t[%s]\n", oldWallet.get(),updatedWallet);
            return new ResponseEntity<>(updatedWallet, HttpStatus.OK);
        } else {
            System.out.printf("Wallet with name [%s] not found!\n", wallet.getName());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping(value = "/")
    public ResponseEntity<List<Wallet>> getAll() {
        return new ResponseEntity<>(walletService.getAll(), HttpStatus.OK);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Wallet> getById(@PathVariable("id") String id) {
        Optional<Wallet> wallet = walletService.getWalletById(id);
        return wallet.isPresent() ? new ResponseEntity<>(wallet.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
