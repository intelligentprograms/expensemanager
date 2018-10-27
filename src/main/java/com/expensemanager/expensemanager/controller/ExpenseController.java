package com.expensemanager.expensemanager.controller;


import com.expensemanager.expensemanager.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;
}
