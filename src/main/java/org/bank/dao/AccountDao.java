package org.bank.dao;

import org.bank.domain.Account;
import org.bank.domain.User;
import org.bank.exception.UserDoesNotHaveAnyAccountException;
import org.bank.storage.BankStore;

public class AccountDao {

    private BankStore bankStore;
    private static final String USER_DOES_NOT_HAVE_ANY_ACCOUNT_EXCEPTION = "user '%s' does have any account";

    public AccountDao() {
        this.bankStore = BankStore.getInstance();
    }

    public Account findByUser(User user) {
        Account account = bankStore.getAccounts().get(user);
        if (account == null) {
            throw new UserDoesNotHaveAnyAccountException(
                String.format(USER_DOES_NOT_HAVE_ANY_ACCOUNT_EXCEPTION, user.getFirstName()));
        }
        return account;
    }
}
