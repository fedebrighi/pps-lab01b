package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BronzeBankAccountTest {
    private CoreBankAccount core;
    private BronzeBankAccount account;
    private final int DEPOSIT_VALUE = 1000;
    private final int EMPTY_ACCOUNT_VALUE = 0;

    @BeforeEach
    void init(){
        this.core = new CoreBankAccount();
        this.account = new BronzeBankAccount(this.core);
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(EMPTY_ACCOUNT_VALUE, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(DEPOSIT_VALUE);
        assertEquals(DEPOSIT_VALUE, this.account.getBalance());
    }

    @Test
    public void testCanWithdrawWithoutFee() {
        int withdrawValue = 99;
        this.account.deposit(DEPOSIT_VALUE);
        this.account.withdraw(withdrawValue);
        assertEquals(DEPOSIT_VALUE - withdrawValue, this.account.getBalance());
    }

    @Test
    public void testCanWithdrawWithFee() {
        int withdrawValue = 101;
        int fee = 1;
        this.account.deposit(DEPOSIT_VALUE);
        this.account.withdraw(withdrawValue);
        assertEquals(DEPOSIT_VALUE - withdrawValue - fee, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawUnderZeroUnits(){
        int overexceedWithdrawValue = 1001;
        this.account.deposit(DEPOSIT_VALUE);
        assertThrows(IllegalStateException.class, ()->this.account.withdraw(overexceedWithdrawValue));
    }
}
