package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    private CoreBankAccount coreAccount;
    private SilverBankAccount account;
    private final int DEPOSIT_VALUE = 1000;
    private final int EMPTY_ACCOUNT_VALUE = 0;

    @BeforeEach
    void init(){
        this.coreAccount = new CoreBankAccount();
        this.account = new SilverBankAccount(coreAccount);
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
    public void testCanWithdraw() {
        int withdrawValue = 200;
        int fee = 1;
        this.account.deposit(DEPOSIT_VALUE);
        this.account.withdraw(withdrawValue);
        assertEquals(DEPOSIT_VALUE - withdrawValue - fee, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(DEPOSIT_VALUE);
        int overexceedWithdrawValue = 1200;
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(overexceedWithdrawValue));
    }

}
