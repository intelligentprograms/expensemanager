package com.expensemanager.expensemanager.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Document
public class Expense {

    @Id
    private String id;
    @Size(min = 1, max = 150)
    private String description;
    @NotNull
    private String categoryId;
    @NotNull
    private String walletId;
    @Min(0)
    private double amount;
    @NotNull
    private Date expenseDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return Double.compare(expense.amount, amount) == 0 &&
                Objects.equals(id, expense.id) &&
                Objects.equals(description, expense.description) &&
                Objects.equals(categoryId, expense.categoryId) &&
                Objects.equals(walletId, expense.walletId) &&
                Objects.equals(expenseDate, expense.expenseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, categoryId, walletId, amount, expenseDate);
    }
}
