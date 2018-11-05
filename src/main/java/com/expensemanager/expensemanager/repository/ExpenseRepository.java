package com.expensemanager.expensemanager.repository;


import com.expensemanager.expensemanager.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends MongoRepository<Expense, String> {
    List<Expense> findByWalletId(String id);
}
