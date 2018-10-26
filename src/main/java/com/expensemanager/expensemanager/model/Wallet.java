package com.expensemanager.expensemanager.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Wallet {

    @Id
    private String id;
    private String name;
    private String userId;
    private String currencyId;
    private WalletType walletType;
    private float amount;

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
