package org.sagilog.service;

import org.sagilog.domain.BankAccount;
import org.sagilog.domain.Transaction;
import org.sagilog.exceptions.TransactionException;

import java.math.BigDecimal;
import java.util.List;

public interface BankAccountService {

    /**
     * this method can withdraw an amount of money from an account
     * @param bankAccount the account of the client
     * @param amount the amount of the operation
     * @throws TransactionException exception thrown when something goes wrong
     */
    void withdraw(BankAccount bankAccount, BigDecimal amount) throws TransactionException;

    /**
     * this method can deposit an amount of money into an account
     * @param bankAccount the account of the client
     * @param amount the amount of the operation
     * @throws TransactionException exception thrown when something goes wrong
     */
    void deposit(BankAccount bankAccount, BigDecimal amount) throws TransactionException;

    /**
     * this method can get history of all transaction done in this account
     * @param bankAccount the account of the client
     * @return List<Transaction> list of the transaction made by the client
     */
    List<Transaction> history(BankAccount bankAccount);
}
