package org.bank.account;

import org.bank.storage.BankStore;
import org.bank.user.User;
import org.bank.user.UserDoesNotHaveAnyAccountException;

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
