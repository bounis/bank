package org.bank.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Account {

    private long balance;
    private User user;
    private Set<Operation> operations;


    public Account() {
    }

    public Account(long balance, User user) {
        this.balance = balance;
        this.user = user;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Operation> getOperations() {
        if (operations == null) {
            operations = new HashSet<>();
        }
        return operations;
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
