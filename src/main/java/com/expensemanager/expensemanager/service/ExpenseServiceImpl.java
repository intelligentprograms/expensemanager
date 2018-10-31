package com.expensemanager.expensemanager.service;

import com.expensemanager.expensemanager.model.Expense;
import com.expensemanager.expensemanager.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Expense oldExpense = expenseRepository.findById(Integer.parseInt(expense.getId()));

        oldExpense.setAmount(expense.getAmount());
        oldExpense.setCategoryId(expense.getCategoryId());
        oldExpense.setDescription(expense.getDescription());
        oldExpense.setExpenseDate(expense.getExpenseDate());
        oldExpense.setWalletId(expense.getWalletId());

        return expenseRepository.save(oldExpense);
    }

    @Override
    public void delete(String id) {
        Expense expense = expenseRepository.findById(Integer.parseInt(id));

        expenseRepository.delete(expense);
    }

    @Override
    public List<Expense> getAll() {
        return expenseRepository.findAll();
    }

    @Override
    public List<Expense> findByWalletId(String id) {
        return expenseRepository.findByWalletId(id);
    }
}
