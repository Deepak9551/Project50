package com.Spring.took.Project50;


import java.util.Random;
import java.util.Scanner;

public class RandomNumber {
    public static void main(String[] args) {
RandomNumberGame.Play();

    }
}
class RandomNumberGame{


    static boolean level_hard = false;

   static Scanner sc  = new Scanner(System.in);

   static  int Total_Attempts = 10;



    public static void Guess_Number_Game(boolean level_hard){
        int count = 0;
        Random random = new Random();

   int guessNumber =   level_hard ? random.nextInt(0,201) :  random.nextInt(0,101);
        if (!level_hard) {
            System.out.println("Guess Random Number 1 - 100");
        }
        else System.out.println("Guess Random Number 1 - 200");



//        System.out.println(i);

        int userInput = sc.nextInt();

        while (userInput != guessNumber){
            count++;
            System.out.println("Total Attempt Left "+ (Total_Attempts - count ));
            if (userInput < guessNumber){
                System.out.println("User Guess is Too Low");
                System.out.println("Guess again");
               userInput = sc.nextInt();
            }
            else{
                System.out.println("User Guess is Too High");
                System.out.println("Guess again");
                userInput = sc.nextInt();
            }


            if(count > Total_Attempts){
                System.out.println("Limit exceeds 10 Attempts ");
                System.out.println("Correct Answer is = "+guessNumber);
                break;
            }


        }
        if (userInput == guessNumber && count <= Total_Attempts){

            System.out.println("correct Answer Guess by User in "+count+" Attempts");
        }
        System.out.println("Do you want to Play again ? (y/n) ");
        String userChoice = sc.next();
        if (userChoice.equalsIgnoreCase("y")) Play();
    }

    public static void Play(){

//        Scanner sc = new Scanner(System.in);

        System.out.println("Do you want to Play the Guess Game ");
        System.out.println("Type 1 If You want to Play");
        System.out.println("Type 2 If You Do not want to Play");
        int option = sc.nextInt();
        switch (option){
            case 1:
                System.out.println("Choose Level ");

                System.out.println("1 for level 1 - 100");
                System.out.println("2 for level 1 - 200");
                int choose = sc.nextInt();
                if (choose == 2){
                    level_hard = true;
                    Guess_Number_Game(level_hard);
                }
                else {
                    level_hard = false;
                    Guess_Number_Game(level_hard);
                }
                break;

            case 2 :
                System.out.println("OK Enjoy");
                break;

            default:
                System.out.println("Wrong Input ");
                Play();
        }
    }

}