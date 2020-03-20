package org.bank.operation;

import java.time.LocalDateTime;
import java.util.Objects;

public class Operation {

    private Type type;
    private long amount;
    private long balance;
    private LocalDateTime date;


    public enum Type {
        DEPOSIT, WITHDRAW
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Operation operation = (Operation) o;
        return amount == operation.amount &&
            balance == operation.balance &&
            type == operation.type &&
            Objects.equals(date, operation.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, amount, balance, date);
    }

    @Override
    public String toString() {
        return "Operation{" +
            "type=" + type +
            ", amount=" + amount +
            ", balance=" + balance +
            ", date=" + date +
            '}';
    }

    public void setType(Type type) {
        this.type = type;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
