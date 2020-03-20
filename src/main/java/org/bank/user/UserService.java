package org.bank.user;

import org.bank.account.Account;

public interface UserService {

    Account findUserAccount(User user);
}
