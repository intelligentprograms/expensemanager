package com.expensemanager.expensemanager.service;

import com.expensemanager.expensemanager.model.Wallet;

import java.util.List;
import java.util.Optional;

public interface WalletService {

    Wallet create(Wallet wallet);
    Wallet update(Wallet wallet);
    void delete(Wallet id);
    List<Wallet> getByUserId(String userdId);
    Optional<Wallet> getWalletById(String walletId);
    boolean existsByNameAndUserId(String name,String userId);
    boolean existsByIdAndName(String id, String name);
    List<Wallet> getAll();

}
