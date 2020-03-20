package org.bank.user;

import org.bank.account.Account;
import org.bank.account.AccountDao;

public class UserServiceImpl implements UserService {

    private AccountDao accountDao;

    public UserServiceImpl() {
        this.accountDao = new AccountDao();
    }

    @Override
    public Account findUserAccount(User user) {
        return accountDao.findByUser(user);
    }
}
