package com.epam.rd.java.basic.practice7.entity;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<>();

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }
}
