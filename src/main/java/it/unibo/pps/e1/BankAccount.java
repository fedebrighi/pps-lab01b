package it.unibo.pps.e1;

/**
 * An interface that defines the concpet of a bank account
 */
public interface BankAccount {

    /**
     * Returns the current balance of the bank account
     * @return the current balance
     */
    int getBalance();

    /**
     * Adds the value of amount to the bank account
     * @param amount the value to be added
     */
    void deposit(int amount);

    /**
     * Removes the value of amount from the bank account
     * @param amount the value to be removed
     */
    void withdraw(int amount);
}
