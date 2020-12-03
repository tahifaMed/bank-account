package org.sagilog.service;

import org.sagilog.domain.BankAccount;
import org.sagilog.domain.Transaction;
import org.sagilog.events.DepositEvent;
import org.sagilog.events.TransactionEvent;
import org.sagilog.events.WithdrawEvent;
import org.sagilog.exceptions.TransactionException;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * this Service Api handles withdraw and deposit money on a specific account
 */
public class BankAccountServiceImpl implements BankAccountService {


    @Override
    public void withdraw(BankAccount bankAccount, BigDecimal amount) throws TransactionException {
        checkAmountNegative(amount);
        checkEnoughBalance(bankAccount, amount);
        BigDecimal newBalance = bankAccount.getBalance().subtract(amount);
        bankAccount.addEvent(new WithdrawEvent(amount, newBalance));
        bankAccount.setBalance(newBalance);
    }

    @Override
    public void deposit(BankAccount bankAccount, BigDecimal amount) throws TransactionException {
        checkAmountNegative(amount);
        BigDecimal newBalance = bankAccount.getBalance().add(amount);
        bankAccount.addEvent(new DepositEvent(amount, newBalance));
        bankAccount.setBalance(newBalance);
    }

    @Override
    public List<Transaction> history(BankAccount bankAccount) {
        return bankAccount.getAccountEvents().stream()
                .filter(TransactionEvent.class::isInstance)
                .map(TransactionEvent.class::cast)
                .map(transactionEvent -> new Transaction(transactionEvent.getAmount(), transactionEvent.getBalance(), transactionEvent.getOperationName(), transactionEvent.getDate()))
                .collect(Collectors.toList());
    }

    private void checkAmountNegative(BigDecimal amount) throws TransactionException {
        if (amount.signum() < 0) {
            throw new TransactionException("the amount of transaction is negative");
        }
    }

    private void checkEnoughBalance(BankAccount bankAccount, BigDecimal amount) throws TransactionException {
        if (bankAccount.getBalance().compareTo(amount) < 0)
            throw new TransactionException("not enough balance");
    }
}
