package org.bank.account;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.bank.BaseTest;
import org.bank.user.User;
import org.bank.user.UserService;
import org.bank.user.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountServiceTest extends BaseTest {

    private AccountService accountService;
    private UserService userService;

    @BeforeEach
    public void setUp() {
        accountService = new AccountServiceImpl();
        userService = new UserServiceImpl();
    }

    @Test
    public void user_account_balance_should_be_incremented_by_deposit_amount_after_deposit_operation() {
        //given
        User user = new User("firstName", "lastName");
        long AMOUNT_TO_DEPOSIT = 2000;
        long currentBalance = userService.findUserAccount(user).getBalance();

        //when
        accountService.deposit(AMOUNT_TO_DEPOSIT, user);

        //then
        long newBalance = userService.findUserAccount(user).getBalance();
        assertThat(newBalance).isEqualTo(currentBalance + AMOUNT_TO_DEPOSIT);
    }

    @Test
    public void user_account_balance_should_be_decremented_by_withdraw_amount_after_withdraw_operation() {
        //given
        User user = new User("firstName_1", "lastName_2");
        long AMOUNT_TO_WITHDRAW = 2000;
        long currentBalance = userService.findUserAccount(user).getBalance();

        //when
        accountService.withdrawal(AMOUNT_TO_WITHDRAW, user);

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
        assertThatThrownBy(() -> accountService.withdrawal(AMOUNT_TO_WITHDRAW, user))
            .isInstanceOf(InsufficientAccountBalanceException.class);
    }
}