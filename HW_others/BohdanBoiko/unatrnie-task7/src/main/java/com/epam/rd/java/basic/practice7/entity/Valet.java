package com.epam.rd.java.basic.practice7.entity;

import java.time.LocalDateTime;
import java.util.Currency;

public class Valet {
    private Type type;
    private int amount;
    private Currency currency;
    private short annualPercentage;
    private LocalDateTime depositTerm;

    public Type getType() {
        return type;
    }

    public Integer getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Short getAnnualPercentage() {
        return annualPercentage;
    }

    public LocalDateTime getDepositTerm() {
        return depositTerm;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void setAnnualPercentage(short annualPercentage) {
        this.annualPercentage = annualPercentage;
    }

    public void setDepositTerm(LocalDateTime depositTerm) {
        this.depositTerm = depositTerm;
    }

    public enum Type {
        SAVINGS_BANK_VALET,
        CURRENT_DEPOSIT_VALET,
        FIXED_DEPOSIT_VALET,
        RECURRING_DEPOSIT_VALET
    }
}
