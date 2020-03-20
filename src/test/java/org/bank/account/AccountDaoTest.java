package org.bank.account;


import java.util.HashSet;
import org.assertj.core.api.Assertions;
import org.bank.BaseTest;
import org.bank.user.User;
import org.bank.user.UserDoesNotHaveAnyAccountException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountDaoTest extends BaseTest {


    private AccountDao accountDao;

    @BeforeEach
    public void setUp() {
        accountDao = new AccountDao();
    }


    @Test
    public void should_get_expected_bank_account_when_calling_find_by_user_in_account_dao() {

        //given
        User user = new User("firstName", "lastName");
        Account expectedAccount = new Account(0, user, new HashSet<>());

        //when
        Account account = accountDao.findByUser(user);

        //then
        Assertions.assertThat(account).isEqualTo(expectedAccount);
    }

    @Test
    public void should_throw_Exception_if_passed_user_does_not_have_bank_account() {

        //given
        User user = new User();

        //when
        //then
        Assertions.assertThatThrownBy(() -> accountDao.findByUser(user)).isInstanceOf(
            UserDoesNotHaveAnyAccountException.class);
    }
}