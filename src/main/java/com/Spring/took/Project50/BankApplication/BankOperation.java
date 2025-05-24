package com.Spring.took.Project50.BankApplication;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class BankOperation {
    private final Bank bank = new Bank();


    public void createAccount(String name ,String father_name, String account_type , String address , String phone_no , String email ,double balance ){

       LocalDateTime dob = LocalDateTime.now();
        Random random = new Random();

        long cif = 100000L + random.nextInt(900000);

        String account_number = "SBI" + (100000000 + random.nextInt(900000000));
       AccountHolder accountHolder = new AccountHolder(name,father_name,address,phone_no,email,dob);
        Account account = new Account(account_number,cif,"SAVING",balance,accountHolder);
       bank.getAccount().add(account);

        System.out.println("==================Account Created Successfully!==============");
        System.out.println("CIF Number: " + cif);
        System.out.println("Account Number: " + account_number);

    }

    public void deposite(String account_number , double amount) {

        if (amount <= 0) {
            throw new InvalidAmountException("Cannot deposit a negative amount.");
        }

        Account account = searchAccount(account_number);
        if (account == null) {
            System.out.println("Incorrect Account Number");
            return;
        }
        if (account != null) {

            double total_amount = account.getBalance() + amount;
            account.setBalance(total_amount);
            System.out.println(total_amount + " amount Successfully Deposited in " + account.getAccountHolder().getName());
            System.out.println("Updated Balance : " + total_amount);
       logToFile(account);
        }
   else      System.out.println("Incorrect Account Number");
    }
    public void withdraw(String account_number , double amount) {

        if (amount <= 0) {
            throw new InvalidAmountException("Cannot withdraw a negative amount.");
        }

        Account account = searchAccount(account_number);
        if (account == null) {
            System.out.println("Incorrect Account Number");
            return;
        }
        if(amount > account.getBalance()){
            throw new InvalidAmountException("Insufficient Balance");
        }
        if (account != null) {

            double total_amount = account.getBalance() - amount;
            account.setBalance(total_amount);
            System.out.println(total_amount + " amount Successfully withdraw in " + account.getAccountHolder().getName());
            System.out.println("Updated Balance : " + total_amount);
        logToFile(account);
        }
      else  System.out.println("Incorrect Account Number");
    }
    public void checkBalance(String account_number ) {


        Account account = searchAccount(account_number);
        if (account != null) {

            System.out.println(
                    "Account Holder Name" + account.getAccountHolder().getName() + " | "+
                     "Account Number " + account.getAccount_number()+ " | "+
                      "Account CIF " + account.getCif_number() + " | "+
                      "Account Balance "+ account.getBalance()
            );
        }
    }


    public Account searchAccount(String account){
        List<Account> bankAccount = bank.getAccount();
       for (Account useraccount : bankAccount){
           if (useraccount.getAccount_number().equals(account)) {
           return useraccount;
           }

           }
       return null;
       }

       public void logToFile(Account account){

    try(PrintWriter printWriter =   new PrintWriter(new FileWriter("bank.txt",true))){
        printWriter.print(
                "Account Holder Name" + account.getAccountHolder().getName() + " | "+
                        "Account Holder Father Name " + account.getAccountHolder().getFather_name() + " | "+
                        "ADDRESS - " + account.getAccountHolder().getAddress() + " | " +
                        "Account Number " + account.getAccount_number()+ " | "+
                        "Account CIF " + account.getCif_number() + " | "+
                        "Account Balance "+ account.getBalance()

        );
        printWriter.flush();
    }catch (IOException e){
        System.out.println("Error While Saving the Data to the File ");
    }

    }
    public void logToRead(){

        try(BufferedReader bf =   new BufferedReader(new FileReader("bank.txt"))){

            String line = bf.readLine();
            while (line != null){
                System.out.println(line);
                line = bf.readLine();
            }

        }catch (IOException e){
            System.out.println("Error While Saving the Data to the File ");
        }

    }
    public void transactions(){
        List<Account> bankAccount = bank.getAccount();
        Map<Long , Account> map = new HashMap<>();
        for (Account account : bankAccount){
            map.put(account.getCif_number() , account);
        }
    }
    public void AccountSerliaze(List<Account> accountList){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("serlizeTransaction.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(accountList);
        objectOutputStream.flush();
        objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
        }


