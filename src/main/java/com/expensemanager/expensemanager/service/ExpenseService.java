package com.expensemanager.expensemanager.service;

import com.expensemanager.expensemanager.model.Expense;

import java.util.List;
import java.util.Optional;

public interface ExpenseService {

    Expense create(Expense expense);
    Expense update(Expense expense);
    void delete(Expense expense);
    //List<Expense> getAll();
    List<Expense> findByWalletId(String login);
    Optional<Expense> getExpenseById(String id);
}
