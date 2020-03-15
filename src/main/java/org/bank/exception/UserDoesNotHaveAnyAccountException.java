package org.bank.exception;

public class UserDoesNotHaveAnyAccountException extends RuntimeException {

    public UserDoesNotHaveAnyAccountException(String message) {
        super(message);
    }
}
