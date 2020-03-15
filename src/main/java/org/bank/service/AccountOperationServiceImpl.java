package org.bank.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.bank.domain.Account;
import org.bank.domain.Operation;
import org.bank.domain.User;
import org.bank.exception.InsufficientAccountBalanceException;
import org.bank.util.OperationDateComparator;

public class AccountOperationServiceImpl implements AccountOperationService {

    private UserService userService;

    public AccountOperationServiceImpl() {
        this.userService = new UserServiceImpl();
    }

    @Override
    public void deposit(long amountToDeposit, User user) {
        Account account = userService.findUserAccount(user);
        long newBalance = account.getBalance() + amountToDeposit;
        account.setBalance(newBalance);
        Operation operation = new Operation();
        operation.setBalance(newBalance);
        operation.setAmount(amountToDeposit);
        operation.setDate(LocalDateTime.now());
        operation.setType(Operation.Type.DEPOSIT);
        account.getOperations().add(operation);
    }

    @Override
    public void withdrawal(long amountToWithdraw, User user) {
        Account account = userService.findUserAccount(user);

        long newBalance = account.getBalance() - amountToWithdraw;
        if (newBalance < 0) {
            throw new InsufficientAccountBalanceException(
                "your balance is insufficient to proceed withdraw");
        }
        account.setBalance(newBalance);
        Operation operation = new Operation();
        operation.setBalance(newBalance);
        operation.setAmount(amountToWithdraw);
        operation.setDate(LocalDateTime.now());
        operation.setType(Operation.Type.WITHDRAW);
        account.getOperations().add(operation);
    }

    @Override
    public List<Operation> accountHistoryOrderByDate(User user) {
        Account account = userService.findUserAccount(user);
        return account.getOperations().stream().sorted(new OperationDateComparator()).collect(
            Collectors.toList());
    }
}
