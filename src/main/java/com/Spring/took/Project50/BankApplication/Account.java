package com.Spring.took.Project50.BankApplication;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Account implements Serializable {

    private String account_number;
    private long cif_number;
    private String account_type;

   private double balance ;

   private AccountHolder accountHolder;

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public long getCif_number() {
        return cif_number;
    }

    public void setCif_number(long cif_number) {
        this.cif_number = cif_number;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountHolder getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(AccountHolder accountHolder) {
        this.accountHolder = accountHolder;
    }

    public Account(String account_number, long cif_number, String account_type, double balance, AccountHolder accountHolder) {
        this.account_number = account_number;
        this.cif_number = cif_number;
        this.account_type = account_type;
        this.balance = balance;
        this.accountHolder = accountHolder;
    }
}
