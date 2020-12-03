package org.sagilog.service;

import org.junit.jupiter.api.*;
import org.sagilog.domain.BankAccount;
import org.sagilog.events.*;
import org.sagilog.exceptions.TransactionException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
class BankAccountServiceImplTest {

    private BankAccount bankAccount;

    private BankAccountService bankAccountService;

    @BeforeEach
    public void init(){
        bankAccount = new BankAccount();
        bankAccount.addEvent(new CreateEvent());
        bankAccountService = new BankAccountServiceImpl();
    }
    @Test
    @DisplayName("withdraw when enough credit")
    void withdraw_when_enough_credit() throws Exception {
        bankAccount.setBalance(BigDecimal.valueOf(100));
        this.bankAccountService.withdraw(bankAccount, BigDecimal.valueOf(10));
        assertEquals(new BigDecimal(90), bankAccount.getBalance());
    }

    @Test
    @DisplayName("withdraw throw exception when there is no enough credit")
    void withdraw_throw_exception_when_not_enough_credit()  {
        bankAccount.addEvent(new WithdrawEvent(new BigDecimal(10), new BigDecimal(100)));
        Assertions.assertThrows(TransactionException.class,()-> this.bankAccountService.withdraw(bankAccount, new BigDecimal(120)));

    }

    @Test
    @DisplayName("withdraw throw exception when amount is negative")
    void withdraw_throw_exception_when_amount_negative() {
        bankAccount.addEvent(new WithdrawEvent(new BigDecimal(10), new BigDecimal(100)));
        Assertions.assertThrows(TransactionException.class,()-> this.bankAccountService.withdraw(bankAccount, new BigDecimal(-10)));

    }

    @Test
    @DisplayName("deposit when amount is positive")
    void deposit_when_amount_positive() throws Exception {
        bankAccount.setBalance(BigDecimal.valueOf(100));
        this.bankAccountService.deposit(bankAccount, new BigDecimal(10));
        assertEquals(new BigDecimal(110), bankAccount.getBalance());
    }

    @Test
    @DisplayName("deposit throw exception when amount is negative")
    void deposit_throw_exception_when_amount_negative() {
        bankAccount.addEvent(new DepositEvent(new BigDecimal(10), new BigDecimal(100)));
        Assertions.assertThrows(TransactionException.class,()-> this.bankAccountService.deposit(bankAccount, new BigDecimal(-10)));

    }

    @Test
    @DisplayName("get list of transactions history")
    void history() {
        bankAccount.addEvent(new DepositEvent(new BigDecimal(10), new BigDecimal(100)));
        assertEquals(1, this.bankAccountService.history(bankAccount).size());
    }
}