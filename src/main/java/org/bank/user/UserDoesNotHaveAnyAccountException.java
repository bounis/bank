package org.bank.user;

public class UserDoesNotHaveAnyAccountException extends RuntimeException {

    public UserDoesNotHaveAnyAccountException(String message) {
        super(message);
    }
}
