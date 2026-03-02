package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GoldBankAccountTest {
    private CoreBankAccount core;
    private GoldBankAccount account;
    private final int DEPOSIT_VALUE = 1000;
    private final int EMPTY_ACCOUNT_VALUE = 0;

    @BeforeEach
    void init(){
        this.core = new CoreBankAccount();
        this.account = new GoldBankAccount(core);
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
        int withdrawValue = 200;
        this.account.deposit(DEPOSIT_VALUE);
        this.account.withdraw(withdrawValue);
        assertEquals(DEPOSIT_VALUE - withdrawValue, this.account.getBalance());
    }

    @Test
    public void testCanWithdrawMoreThanAvailable(){
        int extendedWithdrawValue = 1500;
        this.account.deposit(DEPOSIT_VALUE);
        this.account.withdraw(extendedWithdrawValue);
        assertEquals(DEPOSIT_VALUE - extendedWithdrawValue, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawUnderMinus500Units(){
        int overexceedWithdrawValue = 1501;
        this.account.deposit(DEPOSIT_VALUE);
        assertThrows(IllegalStateException.class, ()->this.account.withdraw(overexceedWithdrawValue));
    }
}
