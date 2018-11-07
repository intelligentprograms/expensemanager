package com.expensemanager.expensemanager.controller;


import com.expensemanager.expensemanager.model.Expense;
import com.expensemanager.expensemanager.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
            Expense createdExpense = expenseService.create(expense);
            System.out.printf("Created expense [%s]\n", createdExpense);
            return new ResponseEntity<>(createdExpense, HttpStatus.OK);
        }


    /**
     * Rest endpoint for deleting a expense by id
     *
     * @param id
     * @return ResponseEntity<String>
     */
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable("id") String id) {
        Optional<Expense> expense = expenseService.getExpenseById(id);
        if (expense.isPresent()) {
            expenseService.delete(expense.get());
            System.out.printf("Expense [%s] has been deleted.\n", expense.get());
            return new ResponseEntity<>("Expense has been deleted", HttpStatus.OK);
        } else {
            System.out.printf("Expense [%s] not found, delete failed.\n", id);
            return new ResponseEntity<>("Expense not found", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Rest endpoint for updating a expense
     *
     * @param expense
     * @return ResponseEntity<Expense>
     */
    @PutMapping(value = "/update")
    public ResponseEntity<Expense> updateExpense(@RequestBody Expense expense) {
        Optional<Expense> oldExpense = expenseService.getExpenseById(expense.getId());
        if (oldExpense.isPresent()) {
            Expense updatedExpense = expenseService.update(expense);
            System.out.printf("Old expense:\t [%s]\nNew expense:\t[%s]\n", oldExpense.get(), updatedExpense);
            return new ResponseEntity<>(updatedExpense, HttpStatus.OK);
        } else {
            System.out.printf("Expense with id [%s] not found!\n", expense.getId());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Rest endpoint which returns an expense by id
     *
     * @param id
     * @return ResponseEntity<Expense>
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Expense> getById(@PathVariable("id") String id) {
        Optional<Expense> expense = expenseService.getExpenseById(id);
        return expense.isPresent() ? new ResponseEntity<>(expense.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Rest endpoint to get expenses for a wallet
     *
     * @param walletId
     * @return ResponseEntity<List<Expense>>
     */
    @GetMapping(value="/wallet/{walletId}")
    public ResponseEntity<List<Expense>> getExpensesForWallet(@PathVariable("walletId") String walletId){
        return new ResponseEntity<>(expenseService.findByWalletId(walletId),HttpStatus.OK);
    }

    /**
     * Rest endpoint to get expenses for a user
     *
     * @param userId
     * @return ResponseEntity<List<Expense>>
     */
    /*@GetMapping(value="/user/{userId}")
    public ResponseEntity<List<Expense>> getExpensesForUser(@PathVariable("userId") String userId){

    }*/

}
