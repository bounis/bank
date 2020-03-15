package org.bank.service;

import org.assertj.core.api.Assertions;
import org.bank.BaseTest;
import org.bank.domain.Account;
import org.bank.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserServiceTest extends BaseTest {

    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserServiceImpl();
    }

    @Test
    public void calling_find_user_account_method_should_return_expected_account() {

        //given
        User user = new User("firstName", "lastName");
        Account expectedAccount = new Account(0, user);

        //when
        Account userAccount = userService.findUserAccount(user);

        //then
        Assertions.assertThat(userAccount).isEqualTo(expectedAccount);
    }
}