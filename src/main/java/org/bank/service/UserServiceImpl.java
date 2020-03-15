package org.bank.service;

import org.bank.dao.AccountDao;
import org.bank.domain.Account;
import org.bank.domain.User;

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
