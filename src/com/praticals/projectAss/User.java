package com.praticals.projectAss;

import java.io.Serializable;
import java.util.Scanner;

public class User implements Comparable <User>, Serializable {
    private String name;
    private int score;
    private int bet; //bet on different game

    User(String name){
        this.name = name;
    }

    public String getName() { return name; }
    public int getScore() {
        return score;
    }
    public int getBet() {
        return bet;
    }

    public void setName(String name) { this.name = name; }
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "User" + name +
                ", has score " + score + '.';
    }


    public int compareTo(User ur) {
        return Integer.compare(score, ur.getScore());
    }

    public void winGame(){
        System.out.println("Well done. You win!");
        this.score += bet;
    }

    public void setBet(Scanner scanSysIn, Game playingGame) {
        System.out.printf("You have %d points.%n",score);
        if (score == 0) {
            // auto set bet to game default points if user got no point
            bet = playingGame.getDefaultScore();
            System.out.println("Use default game point.");
        }else {
            int wannaBet;
            while (true) {
                System.out.println("Enter an positive integer as your bet for this round " +
                        "or 0 to use default score of the game.");
                // make sure input a positive integer
                while (!scanSysIn.hasNextInt()) {
                    System.out.println("That is not a integer.");
                    scanSysIn.next();
                }
                wannaBet = scanSysIn.nextInt();

                // non negative and VIP can bet on multiple times of their score
                if(wannaBet >= 0 && wannaBet <= this.getScore()){
                    break;
                }else {
                    // print error message
                    System.out.println(
                        wannaBet < 0 ? "Cannot bet on negatives." :
                            wannaBet > this.getScore() ?
                                "You don't have enough points to bet." : "");
                }
            }
            bet = wannaBet == 0 ? playingGame.getDefaultScore(): wannaBet; //set bet points
        }
        System.out.printf("Bet %d points on this round. %n", bet);
    }

    public void greet(){
        System.out.printf("Hello, %s. Please choose a game to start. %n", this.getName());
    }
}
