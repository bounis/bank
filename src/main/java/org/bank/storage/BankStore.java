package org.bank.storage;

import java.util.HashMap;
import java.util.Map;
import org.bank.account.Account;
import org.bank.user.User;

public class BankStore {

    private static BankStore instance;
    private final Map<User, Account> accounts;

    private BankStore() {
        accounts = new HashMap<>();
    }

    public static BankStore getInstance() {
        if (instance == null) {
            synchronized (BankStore.class) {
                instance = new BankStore();
            }
        }
        return instance;
    }

    public Map<User, Account> getAccounts() {
        return accounts;
    }
}
