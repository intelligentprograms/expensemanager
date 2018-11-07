package com.expensemanager.expensemanager.service;

import com.expensemanager.expensemanager.model.Expense;
import com.expensemanager.expensemanager.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService{


    @Autowired
    private ExpenseRepository expenseRepository;


    @Override
    public Expense create(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public Expense update(Expense expense) {
        Expense oldExpense = expenseRepository.findById(expense.getId()).get();
        oldExpense.setAmount(expense.getAmount());
        oldExpense.setCategoryId(expense.getCategoryId());
        oldExpense.setDescription(expense.getDescription());
        oldExpense.setExpenseDate(expense.getExpenseDate());
        oldExpense.setWalletId(expense.getWalletId());

        return expenseRepository.save(oldExpense);
    }


    @Override
    public void delete(Expense expense) {
        expenseRepository.delete(expense);
    }

    /*@Override
    public List<Expense> getAll() {
        return expenseRepository.findAll();
    }*/

    @Override
    public List<Expense> findByWalletId(String id) {
        return expenseRepository.findByWalletId(id);
    }
    @Override
    public Optional<Expense> getExpenseById(String id) {
        return expenseRepository.findById(id);
    }
}
