package com.expensemanager.expensemanager.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document
public class ExpenseCategory {

    @Id
    private String id;
    @NotNull
    private ExpenseCategoryType categoryType;
    @Size(min = 1, max = 150)
    private String name;
    @Size(min = 0, max = 150)
    private String description;

}
