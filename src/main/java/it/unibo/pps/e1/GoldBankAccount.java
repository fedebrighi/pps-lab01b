package it.unibo.pps.e1;

public class GoldBankAccount implements BankAccount{

    private final CoreBankAccount base;
    private final int WITHDRAW_THRESHOLD = -500;
    public GoldBankAccount(CoreBankAccount account){
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
        if(this.base.getBalance() - amount < WITHDRAW_THRESHOLD){
            throw new IllegalStateException("Cannot have a negative balance over -500");
        }
        this.base.withdraw(amount);
    }
}
