package org.bank.service;

import org.bank.domain.Account;
import org.bank.domain.User;

public interface UserService {

    Account findUserAccount(User user);
}
