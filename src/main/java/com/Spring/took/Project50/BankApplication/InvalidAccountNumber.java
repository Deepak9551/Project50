package com.Spring.took.Project50.BankApplication;

public class InvalidAccountNumber extends RuntimeException {
    public InvalidAccountNumber(String message) {
        super(message);
    }
}
