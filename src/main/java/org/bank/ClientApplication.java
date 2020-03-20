package org.bank;

import org.bank.account.AccountService;
import org.bank.account.AccountServiceImpl;
import org.bank.operation.OperationService;
import org.bank.operation.OperationServiceImpl;
import org.bank.user.User;
import org.bank.util.BankStoreDataGenerator;

public class ClientApplication {

    public static void main(String[] args) {
        BankStoreDataGenerator.generateBankData();
        User user = new User("firstName", "lastName");
        AccountService accountService = new AccountServiceImpl();
        OperationService operationService = new OperationServiceImpl();
        accountService.deposit(2000, user);
        accountService.withdrawal(1000, user);

        operationService.accountHistoryOrderByDate(user).forEach(System.out::println);
    }
}
