package com.expensemanager.expensemanager.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Document
public class Wallet {

    @Id
    private String id;
    @NotNull
    @Size(min = 3, max = 20)
    private String name;
    @NotNull
    private String userId;
    @NotNull
    private String currencyId;
    @NotNull
    private WalletType walletType;
    @Min(0)
    private float amount;
    private List<Expense> expense;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public WalletType getWalletType() {
        return walletType;
    }

    public void setWalletType(WalletType walletType) {
        this.walletType = walletType;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public List<Expense> getExpense() { return expense; }

    public void setExpense(List<Expense> expense) { this.expense = expense; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return Float.compare(wallet.amount, amount) == 0 &&
                Objects.equals(id, wallet.id) &&
                Objects.equals(name, wallet.name) &&
                Objects.equals(userId, wallet.userId) &&
                Objects.equals(currencyId, wallet.currencyId) &&
                walletType == wallet.walletType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, userId, currencyId, walletType, amount);
    }
}
