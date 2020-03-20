package org.bank.account;

import org.bank.user.User;

public interface AccountService {

    void deposit(long amountToDeposit, User user);

    void withdrawal(long amountToWithdraw, User user);

}
