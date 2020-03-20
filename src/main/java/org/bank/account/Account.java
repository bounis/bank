package org.bank.account;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.bank.operation.Operation;
import org.bank.user.User;

public class Account {

    private final long balance;
    private final User user;
    private final Set<Operation> operations;


    public Account(long balance, User user, Set<Operation> operations) {
        this.balance = balance;
        this.user = user;
        this.operations = operations;
    }

    public long getBalance() {
        return balance;
    }

    public User getUser() {
        return user;
    }

    public Set<Operation> getOperations() {
        return new HashSet<>(operations);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return balance == account.balance &&
            Objects.equals(user, account.user) &&
            Objects.equals(operations, account.operations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance, user, operations);
    }
}
