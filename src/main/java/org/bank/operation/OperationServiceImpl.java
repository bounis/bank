package org.bank.operation;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.bank.account.Account;
import org.bank.user.User;
import org.bank.user.UserService;
import org.bank.user.UserServiceImpl;

public class OperationServiceImpl implements OperationService {

    private UserService userService;

    public OperationServiceImpl() {
        this.userService = new UserServiceImpl();
    }

    @Override
    public List<Operation> accountHistoryOrderByDate(User user) {
        Account account = userService.findUserAccount(user);
        return account.getOperations().stream().sorted(Comparator.comparing(Operation::getDate))
            .collect(Collectors.toList());
    }
}
