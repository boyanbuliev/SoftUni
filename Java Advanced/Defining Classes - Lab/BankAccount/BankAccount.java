package BankAccount;

import java.text.DecimalFormat;

public class BankAccount {
    private static int idCounter = 1;
    private int id;
    private double balance;
    private static double interestRate = 0.02;

    public BankAccount() {
        this.id = BankAccount.idCounter++;

        System.out.println("Account ID" + this.id + " created");
    }

    public static void setInterestRate(double interest) {
        interestRate = interest;
    }

    public double getInterestRate(int years) {
        return this.balance * interestRate * years;
    }

    public void deposit(double amount) {
        this.balance += amount;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        System.out.println("Deposited " + decimalFormat.format(amount) + " to ID" + this.id);
    }

    public int getId() {
        return this.id;
    }
}

