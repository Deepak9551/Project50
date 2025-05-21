package com.Spring.took.Project50.Calculator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class  Calculator{
    public static void main(String[] args) {
        MyCalculator myCalculator = new MyCalculator();
        myCalculator.myCalculatorInput();

    }
}

 class MyCalculator {
    boolean flag = true;
    Scanner sc = new Scanner(System.in);

    public void myCalculatorInput(){

        System.out.println("==== Welcome to Deepak's Calculator ====");
        while (flag) {
       
            System.out.println("Choose Operation");
            System.out.println("1 for Add");
            System.out.println("2 for Subtract");
            System.out.println("3 for Multiply");
            System.out.println("4 for Division");
            System.out.println("5 for Remainder");
            System.out.println("6 for Bulk Add");
            System.out.println("7 for Bulk Subtract");
            System.out.println("8 for Bulk Multiple");
            System.out.println("0 for Exit");

            int operation = sc.nextInt();

            myCalculatoropertion(operation);

            System.out.println("Do you want to Continue (y/n)");
            String option = sc.next();
            if (option.equalsIgnoreCase("n")){
                flag = false;
                System.out.println("Good Bye !!");
            }
        }


    }
    public void bulkAdd(String number){
        int addValue = 0;
        String[] token = number.split("[,\\s]");
        for (String s : token){
            try {
                int i = Integer.parseInt(s);
                addValue += i;
            } catch (NumberFormatException e) {
                System.out.println("Skipping invalid input: " + s);
            }
        }
        System.out.println("Sum of all numbers = " + addValue);

    }
     public void bulkSubtract(String number){
         int subValue ;
         String[] token = number.split("[,\\s]");
         if(token.length == 0){
             return;
         }
         try {
             subValue =  Integer.parseInt(token[0]);
         } catch (NumberFormatException e) {
             System.out.println("Skipping invalid input: " + token[0]);
             return;
         }
         for (int i = 1;i<token.length;i++){
             try {
                 int sub = Integer.parseInt(token[i]);
                 subValue -= sub;
             } catch (NumberFormatException e) {
                 System.out.println("Skipping invalid input: " + token[i]);
             }
         }
         System.out.println("Subtract of all numbers = " + subValue);

     }

     public void bulkMultiply(String number){
         String[] token = number.split("[,\\s]");
        int multiple = 1;
         if(token.length == 0 && multiple ==1){
             System.out.println("Please insert number");
             return;
         }
//         try {
//             multiple = Integer.parseInt(token[0]);
//         } catch (NumberFormatException e) {
//             System.out.println("Skipping invalid input: " + token[0]);
//             return;
//         }
         for (String s : token){
             try {
                 int value = Integer.parseInt(s);
                 multiple *= value;
             } catch (NumberFormatException e) {
                 System.out.println("Skipping invalid input: " + s);
             }
         }
         System.out.println("Multiple of all numbers = " + multiple);
     }

    public void myCalculatoropertion(int operation){

        int a = 0;
        int b = 0;
        if (operation >= 1 && operation <= 5) {
            System.out.println("Input the First Number ");
            a = sc.nextInt();
            System.out.println("Input the Second Number");
            b = sc.nextInt();
        }

        switch (operation){
            case 1 :
                add(a,b);
                break;
            case 2 :
                subtract(a,b);
                break;
            case 3 :
                multiply(a,b);

                break;

            case 4:
                division(a,b);
                break;

            case 5 :
                remainder(a,b);
            break;
            case 6:
                sc.nextLine(); // clear buffer
                System.out.println("Enter numbers (space/comma separated): ");
                String addline = sc.nextLine();
                bulkAdd(addline);
                break;
            case 7:
                sc.nextLine(); // clear buffer
                System.out.println("Enter numbers (space/comma separated): ");
                String subline = sc.nextLine();
                bulkSubtract(subline);
        break;
            case 8:
                sc.nextLine(); // clear buffer
                System.out.println("Enter numbers (space/comma separated): ");
                String multline = sc.nextLine();
                bulkMultiply(multline);
                break;
            case 0 :
                exit();
                break;

            default:
                System.out.println("Invalid operation selected.");
                break;

        }
    }

    public void add(int a , int b){

        System.out.println("Addition = "+ (a + b));
       logToFile(a + " + " + b + " = " + (a+b));
    }
    public void subtract(int a , int b){
        System.out.println("Subtract = "+ (a - b));
    }
    public void multiply(int a , int b){
        System.out.println("Multiply = "+ (a * b));
    }
    public void division(int a , int b){
        if(b == 0){
            System.out.println("Invalid Division by /0");
            return;
        }
        System.out.println("Division = "+ (a / b));
    }
    public void remainder(int a , int b){
        System.out.println("Remainder = "+ (a % b));
    }
    public void exit(){
        System.out.println("Good Bye");
        System.exit(0);
    }


    public void logToFile(String msg){
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter("cal.txt",true));
            printWriter.println(msg);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}


