package it.unibo.pps.e1;

public class BronzeBankAccount implements BankAccount{

    private final CoreBankAccount base;
    private final int WITHDRAW_FEE = 1;

    public BronzeBankAccount(CoreBankAccount account){
        this.base = account;
    }

    @Override
    public int getBalance() {
        return this.base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        this.base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        if(this.base.getBalance() - amount < 0){
            throw new IllegalStateException("Balance must always be >= 0");
        }
        else if (amount < 100) {
            this.base.withdraw(amount);
        } else {
            this.base.withdraw(amount + WITHDRAW_FEE);
        }
    }
}
