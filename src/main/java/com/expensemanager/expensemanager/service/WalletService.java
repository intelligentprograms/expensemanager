package com.expensemanager.expensemanager.service;

import com.expensemanager.expensemanager.model.Wallet;

import java.util.List;

public interface WalletService {

    Wallet createWallet(Wallet wallet);
    Wallet updateWallet(Wallet wallet);
    void deleteWallet(String id);
    List<Wallet> getAll();

    List<Wallet> getAllForUser(String userId);

}
