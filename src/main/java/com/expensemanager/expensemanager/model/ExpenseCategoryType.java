package com.expensemanager.expensemanager.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public enum ExpenseCategoryType {

    CAR,
    HOME,
    DINING,
    GROCERIES,
    CLOTHING,
    PERSONAL,
    EDUCATION,
    ENTERTAINMENT,
    DEBT,
    UTILITIES,
    INSURANCE,
    TAXES,
    MISC;
}
