package org.bank.service;

import java.util.List;
import org.bank.domain.Operation;
import org.bank.domain.User;

public interface AccountOperationService {

    void deposit(long amountToDeposit, User user);

    void withdrawal(long amountToWithdraw, User user);

    List<Operation> accountHistoryOrderByDate(User user);
}
