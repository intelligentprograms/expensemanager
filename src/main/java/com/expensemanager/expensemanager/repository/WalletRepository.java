package com.expensemanager.expensemanager.repository;

import com.expensemanager.expensemanager.model.Wallet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletRepository extends MongoRepository<Wallet, String> {

    Wallet getById(String id);

    List<Wallet> getByUserId(String userId);
}
