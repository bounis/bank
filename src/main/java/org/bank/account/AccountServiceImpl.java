package org.bank.account;

import java.time.LocalDateTime;
import java.util.Set;
import org.bank.operation.Operation;
import org.bank.storage.BankStore;
import org.bank.user.User;
import org.bank.user.UserService;
import org.bank.user.UserServiceImpl;

public class AccountServiceImpl implements AccountService {

    private UserService userService;

    public AccountServiceImpl() {
        this.userService = new UserServiceImpl();
    }

    @Override
    public void deposit(long amountToDeposit, User user) {
        Account oldAccount = userService.findUserAccount(user);
        long newBalance = oldAccount.getBalance() + amountToDeposit;

        Operation operation = new Operation();
        operation.setBalance(newBalance);
        operation.setAmount(amountToDeposit);
        operation.setDate(LocalDateTime.now());
        operation.setType(Operation.Type.DEPOSIT);
        Set<Operation> operations = oldAccount.getOperations();
        operations.add(operation);
        Account account = new Account(newBalance, user, operations);

        BankStore.getInstance().getAccounts().replace(user, oldAccount, account);
    }

    @Override
    public void withdrawal(long amountToWithdraw, User user) {
        Account oldAccount = userService.findUserAccount(user);

        long newBalance = oldAccount.getBalance() - amountToWithdraw;
        if (newBalance < 0) {
            throw new InsufficientAccountBalanceException(
                "your balance is insufficient to proceed withdraw");
        }
        Operation operation = new Operation();
        operation.setBalance(newBalance);
        operation.setAmount(amountToWithdraw);
        operation.setDate(LocalDateTime.now());
        operation.setType(Operation.Type.WITHDRAW);
        Set<Operation> operations = oldAccount.getOperations();
        operations.add(operation);
        Account account = new Account(newBalance, user, operations);

        BankStore.getInstance().getAccounts().replace(user, oldAccount, account);
    }
}
