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

    /**
     * Rest endpoint for creating new wallet
     *
     * @param wallet
     * @return ResponseEntity<Wallet>
     */
    @PostMapping(value = "/create")
    public ResponseEntity<Wallet> createWallet(@RequestBody Wallet wallet) {

        if (walletService.existsByNameAndUserId(wallet.getName(), wallet.getUserId())) {
            System.out.printf("User [%s] have already wallet with name [%s]\n", wallet.getUserId(), wallet.getName());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            Wallet createdWallet = walletService.create(wallet);
            System.out.printf("Created wallet [%s]\n", createdWallet);
            return new ResponseEntity<>(createdWallet, HttpStatus.OK);
        }
    }

    /**
     * Rest endpoint for deleting a wallet by id
     *
     * @param id
     * @return ResponseEntity<String>
     */
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

    /**
     * Rest endpoint for updating a wallet
     *
     * @param wallet
     * @return ResponseEntity<Wallet>
     */
    @PutMapping(value = "/update")
    public ResponseEntity<Wallet> updateWallet(@RequestBody Wallet wallet) {
        Optional<Wallet> oldWallet = walletService.getWalletById(wallet.getId());
        if (oldWallet.isPresent()) {
            Wallet updatedWallet = walletService.update(wallet);
            System.out.printf("Old wallet:\t [%s]\nNew wallet:\t[%s]\n", oldWallet.get(), updatedWallet);
            return new ResponseEntity<>(updatedWallet, HttpStatus.OK);
        } else {
            System.out.printf("Wallet with id [%s] not found!\n", wallet.getId());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //TO DO: check if there is need for this endpoint
    @GetMapping(value = "/")
    public ResponseEntity<List<Wallet>> getAllWallets() {
        return new ResponseEntity<>(walletService.getAll(), HttpStatus.OK);
    }

    /**
     * Rest endpoint which returns a wallet by id
     *
     * @param id
     * @return ResponseEntity<Wallet>
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Wallet> getById(@PathVariable("id") String id) {
        Optional<Wallet> wallet = walletService.getWalletById(id);
        return wallet.isPresent() ? new ResponseEntity<>(wallet.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Rest endpoint to get wallets for a user
     *
     * @param userId
     * @return ResponseEntity<List<Wallet>>
     */
    @GetMapping(value="/user/{userId}")
    public ResponseEntity<List<Wallet>> getUserWallets(@PathVariable("userId") String userId){
        return new ResponseEntity<>(walletService.getByUserId(userId),HttpStatus.OK);
    }


}
