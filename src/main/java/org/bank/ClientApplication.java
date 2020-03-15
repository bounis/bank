package org.bank;

import org.bank.domain.User;
import org.bank.service.AccountOperationService;
import org.bank.service.AccountOperationServiceImpl;
import org.bank.util.BankStoreDataGenerator;

public class ClientApplication {

    public static void main(String[] args) {
        BankStoreDataGenerator.generateBankData();
        User user = new User("firstName", "lastName");
        AccountOperationService accountOperationService = new AccountOperationServiceImpl();
        accountOperationService.deposit(2000, user);
        accountOperationService.withdrawal(1000, user);

        accountOperationService.accountHistoryOrderByDate(user).forEach(System.out::println);
    }
}
