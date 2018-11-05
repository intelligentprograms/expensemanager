package com.expensemanager.expensemanager.service;


import com.expensemanager.expensemanager.model.Wallet;
import com.expensemanager.expensemanager.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Override
    public Wallet create(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    @Override
    public Wallet update(Wallet wallet) {
        Optional<Wallet> oldWallet = walletRepository.findById(wallet.getId());
        Wallet _oldWallet = oldWallet.get();
        _oldWallet.setName(wallet.getName());
        _oldWallet.setAmount(wallet.getAmount());
        _oldWallet.setCurrencyId(wallet.getCurrencyId());
        _oldWallet.setWalletTypeId(wallet.getWalletTypeId());
        return walletRepository.save(_oldWallet);
    }

    @Override
    public void delete(Wallet wallet) {
        if (walletRepository.existsByIdAndName(wallet.getId(), wallet.getName())) {
            walletRepository.delete(wallet);
        }
    }


    @Override
    public List<Wallet> getByUserId(String userId) {
        return walletRepository.getByUserId(userId);
    }

    @Override
    public Optional<Wallet> getWalletById(String walletId) {
        return walletRepository.findById(walletId);
    }

    @Override
    public boolean existsByIdAndName(String id, String name) {
        return walletRepository.existsByIdAndName(id, name);
    }

    public boolean existsByName(String name) {
        return walletRepository.existsByName(name);
    }

    @Override
    public List<Wallet> getAll() {
        return walletRepository.findAll();
    }
}
