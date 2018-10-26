package com.expensemanager.expensemanager.service;


import com.expensemanager.expensemanager.model.Wallet;
import com.expensemanager.expensemanager.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepository walletRepository;


    @Override
    public Wallet createWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    @Override
    public Wallet updateWallet(Wallet wallet) {
        Wallet oldWallet = walletRepository.getById(wallet.getId());

        oldWallet.setName(wallet.getName());
        oldWallet.setAmount(wallet.getAmount());
        oldWallet.setCurrencyId(wallet.getCurrencyId());
        oldWallet.setWalletType(wallet.getWalletType());

        return walletRepository.save(oldWallet);
    }

    @Override
    public void deleteWallet(String id) {
        Wallet wallet = walletRepository.getById(id);
        walletRepository.delete(wallet);
    }

    @Override
    public List<Wallet> getAll() {
        return walletRepository.findAll();
    }

    @Override
    public List<Wallet> getAllForUser(String userId) {
        return walletRepository.getAllForUser(userId);
    }
}
