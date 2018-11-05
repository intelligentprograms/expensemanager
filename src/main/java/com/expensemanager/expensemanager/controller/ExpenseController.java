package com.expensemanager.expensemanager.controller;


import com.expensemanager.expensemanager.model.Expense;
import com.expensemanager.expensemanager.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;


    /**
     * Rest endpoint for creating new expense
     *
     * @param expense
     * @return ResponseEntity<Wallet>
     */
    @PostMapping(value = "/create")
    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) {
        //Optional<Expense> newExpense = expenseService.getExpenseById(expense.getId());
            Expense createdExpense = expenseService.create(expense);
            System.out.printf("Created expense [%s]\n", createdExpense);
            return new ResponseEntity<>(createdExpense, HttpStatus.OK);
        }
}
