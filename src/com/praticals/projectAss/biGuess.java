package com.praticals.projectAss;

import java.util.Random;
import java.util.Scanner;

public class biGuess extends Game{

    biGuess(){
        super("Guess the secret number");
        this.setDescription("Guess the secret integer within limit rounds.");
    }

    @Override
    public void GameOn(User currentPlayer, Scanner scanSysIn) {
        Random rand = new Random();
        int top = 30;
        int target = rand.nextInt(top+1);

        int roundLimit = 3;
        int round = 0;

        System.out.printf("Secret in range 0 to %d. Guess it with in %d rounds.%n", top, roundLimit);
        System.out.println(target);

        while (round < roundLimit){
            System.out.printf("This is %d guess, you have %d guess left. %n " +
                    "Enter your best guess: ", round+1, roundLimit-round);
            if(!scanSysIn.hasNextInt()){
                scanSysIn.next();
                System.out.println("Invalid input, try again.");
            }else {
                int guessInt = scanSysIn.nextInt();
                round ++;
                if(guessInt==target){
                    System.out.println("Your are right! Secret number is "+target+" .");
                    currentPlayer.winGame();
                    return;
                }else if (guessInt > target){
                    System.out.println("Wrong answer. Try smaller guess.");
                }else {
                    System.out.println("Wrong answer. Try bigger guess.");
                }
            }
        }

        System.out.println("Run out of guesses. You failed.");
        System.out.println("The secret number is "+target+".");
    }
}
