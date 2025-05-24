package com.Spring.took.Project50.BankApplication;

import java.time.LocalDateTime;
import java.util.Scanner;

public class UserInterface {
  static   boolean flag = true ;
    public static void main(String[] args) {
        BankOperation bankOperation = new BankOperation();

        Scanner sc = new Scanner(System.in);
        System.out.println("==================== SASTA BANK =================");
        System.out.println("Choose your option");
        System.out.println("Enter User  name");
        String username = sc.nextLine();
        System.out.println("Enter Father Name");
       String father_name = sc.nextLine();
        System.out.println("Enter User Address ");
        String address = sc.nextLine();
        System.out.println("Enter Phone Number");
        String phone = sc.nextLine();
        System.out.println("Enter User Email ");
        String email = sc.nextLine();
        System.out.println("Enter Initial Balance ");
        double balance = sc.nextDouble();

        while (flag) {
            System.out.println("1 for Create User Bank Account ");
            System.out.println("2 for Deposite money ");
            System.out.println("3 for Withdraw Money");
            System.out.println("4 Check Balance");
            System.out.println("5 Check History");
            System.out.println("6 Exit ");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:

                    bankOperation.createAccount(username, father_name, "Saving", address, phone, email, balance);

                    break;
                case 2:
                    System.out.println("Enter Account Number");
                    String accNo = sc.nextLine();
                    System.out.println("Enter Amount");
                    double amount = sc.nextDouble();
                    bankOperation.deposite(accNo, amount);
                    break;

                case 3:
                    System.out.println("Enter Account Number");
                    String accNoForWithdraw = sc.nextLine();
                    System.out.println("Enter Amount ");
                    double amountForWithDraw = sc.nextDouble();
                    bankOperation.withdraw(accNoForWithdraw, amountForWithDraw);
                    break;

                case 4:
                    System.out.println("Enter Account Number");
                    String accNoForCheckBalance = sc.nextLine();

                    bankOperation.checkBalance(accNoForCheckBalance);
                    break;

                case 5:
                    System.out.println("================== HISTORY OF PAST ===============");
                    bankOperation.logToRead();
                case 6 :
                    flag = false;
                    System.out.println("BYE BYE ");
            }
        }


    }
}
