package com.epam.rd.java.basic.practice7.util;

import com.epam.rd.java.basic.practice7.entity.Account;
import com.epam.rd.java.basic.practice7.entity.Bank;
import com.epam.rd.java.basic.practice7.entity.Valet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sorter {
    private Sorter() {
    }

    public static void sortAccountsById(Bank bank) {
        bank.getAccounts().sort(Comparator.comparing(Account::getId));
    }

    public static void sortAccountsByDepositor(Bank bank) {
        bank.getAccounts().sort(Comparator.comparing(Account::getDepositor));
    }

    public static void sortValetsByAmount(Bank bank) {
        List<Account> accounts = new ArrayList<>();

        for (Account account : bank.getAccounts()) {
            List<Valet> valets = account.getValets();
            valets.sort(Comparator.comparing(Valet::getAmount));
            account.setValets(valets);
            accounts.add(account);
        }

        bank.setAccounts(accounts);
    }
}
