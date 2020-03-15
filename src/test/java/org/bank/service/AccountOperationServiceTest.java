package org.bank.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.bank.BaseTest;
import org.bank.domain.Operation;
import org.bank.domain.User;
import org.bank.exception.InsufficientAccountBalanceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountOperationServiceTest extends BaseTest {

    private AccountOperationService accountOperationService;
    private UserService userService;

    @BeforeEach
    public void setUp() {
        accountOperationService = new AccountOperationServiceImpl();
        userService = new UserServiceImpl();
    }

    @Test
    public void user_account_balance_should_be_incremented_by_deposit_amount_after_deposit_operation() {
        //given
        User user = new User("firstName", "lastName");
        long AMOUNT_TO_DEPOSIT = 2000;
        long currentBalance = userService.findUserAccount(user).getBalance();

        //when
        accountOperationService.deposit(AMOUNT_TO_DEPOSIT, user);

        //then
        long newBalance = userService.findUserAccount(user).getBalance();
        assertThat(newBalance).isEqualTo(currentBalance + AMOUNT_TO_DEPOSIT);
    }

    @Test
    public void user_account_balance_should_be_decremented_by_withdraw_amount_after_withdrawl_operation() {
        //given
        User user = new User("firstName_1", "lastName_2");
        long AMOUNT_TO_WITHDRAW = 2000;
        long currentBalance = userService.findUserAccount(user).getBalance();

        //when
        accountOperationService.withdrawal(AMOUNT_TO_WITHDRAW, user);

        //then
        long newBalance = userService.findUserAccount(user).getBalance();
        assertThat(newBalance).isEqualTo(currentBalance - AMOUNT_TO_WITHDRAW);
    }

    @Test()
    public void withdraw_operation_should_return_exception_if_user_runs_out_of_balance() {
        //given
        User user = new User("firstName", "lastName");
        long AMOUNT_TO_WITHDRAW = 2000;

        //when
        //then
        assertThatThrownBy(() -> accountOperationService.withdrawal(AMOUNT_TO_WITHDRAW, user))
            .isInstanceOf(InsufficientAccountBalanceException.class);
    }

    @Test
    public void demanding_account_history_should_return_operations_ordered_By_date() {
        //given
        User user = new User("firstName_1", "lastName_2");

        //when
        List<Operation> operations = accountOperationService.accountHistoryOrderByDate(user);

        //then
        assertThat(operations.size()).isEqualTo(2);

        assertThat(operations.get(0).getType()).isEqualTo(Operation.Type.DEPOSIT);
        assertThat(operations.get(0).getBalance()).isEqualTo(3000);
        assertThat(operations.get(0).getAmount()).isEqualTo(3000);

        assertThat(operations.get(1).getType()).isEqualTo(Operation.Type.WITHDRAW);
        assertThat(operations.get(1).getBalance()).isEqualTo(2000);
        assertThat(operations.get(1).getAmount()).isEqualTo(1000);
    }
}