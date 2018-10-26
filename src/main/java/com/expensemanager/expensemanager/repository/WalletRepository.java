package com.expensemanager.expensemanager.repository;

import com.expensemanager.expensemanager.model.Wallet;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WalletRepository extends MongoRepository<Wallet, String> {

    Wallet getById(String id);

    List<Wallet> getAllForUser(String userId);
}
