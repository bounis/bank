package org.bank.util;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import org.bank.domain.Account;
import org.bank.domain.Operation;
import org.bank.domain.User;
import org.bank.storage.BankStore;

public class BankStoreDataGenerator {

    public static void generateBankData() {
        Map<User, Account> accounts = new HashMap<>();

        User user = new User("firstName", "lastName");
        Account account = new Account(0, user);
        accounts.put(user, account);

        User user_1 = new User("firstName_1", "lastName_2");
        Account account_1 = new Account(2000, user_1);
        accounts.put(user_1, account_1);
        Operation operation_1 = new Operation();
        operation_1.setType(Operation.Type.DEPOSIT);
        operation_1.setAmount(3000);
        operation_1.setBalance(3000);
        operation_1.setDate(LocalDateTime.of(2020, Month.JANUARY, 2, 10, 10));
        account_1.getOperations().add(operation_1);
        Operation operation_2 = new Operation();
        operation_2.setType(Operation.Type.WITHDRAW);
        operation_2.setAmount(1000);
        operation_2.setBalance(2000);
        operation_2.setDate(LocalDateTime.of(2020, Month.FEBRUARY, 3, 10, 10));
        account_1.getOperations().add(operation_2);

        BankStore.getInstance().getAccounts().putAll(accounts);
    }
}
