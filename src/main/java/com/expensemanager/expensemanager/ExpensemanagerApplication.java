package com.expensemanager.expensemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.expensemanager.expensemanager")
public class ExpensemanagerApplication {

    public static void main(String... args){
        SpringApplication.run(ExpensemanagerApplication.class, args);
    }
}
