package com.praticals.projectAss;

import java.util.Scanner;

public class User implements Comparable <User>{
    private int id;
    private String name;
    private Game playingGame;
    private int score;
    private int bet; //bet on different game
    private boolean is_vip = false;
    private int betTimes = 1;

    User(String name, boolean is_vip){
        this.name = name;
        if(is_vip){
            this.is_vip = true;
            score = 10; // give extra points for vip users
            betTimes = 2; //VIP can bet on twice of their score
        }
    }


    public int getId() { return id; }
    public String getName() { return name; }
    public Game getPlayingGame() { return playingGame; }
    public int getScore() {
        return score;
    }
    public int getBet() {
        return bet;
    }
    public int getBetTimes(){return betTimes;}

    public void setName(String name) { this.name = name; }
    public void setPlayingGame(Game playingGame) { this.playingGame = playingGame; }

    @Override
    public String toString() {
        return "User" + name +
                ": id is " + id +
                ", is playing Game " + playingGame.toString() + '.';
    }


    public int compareTo(User ur) {
        return Integer.compare(score, ur.getScore());
//        if (score > ur.getScore()){
//            return 1;
//        }else if (score == ur.getScore()){
//            return 0;
//        }else {return -1;}
    }

    public void winGame(){
        this.score += bet;
    }

    public void setBet(Scanner scanSysIn) {
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

                if(wannaBet >= 0 && wannaBet <= this.getScore()){
                    break;
                }else {
                    // print error message
                    System.out.println(
                            wannaBet < 0 ? "Cannot bet on negatives." :
                                    wannaBet > this.getScore()*this.getBetTimes() ?
                                            "You don't have enough points to bet." : ""
                    );
                }
            }
            bet = wannaBet == 0 ? this.playingGame.getDefaultScore(): wannaBet; //set bet points
//            scan.close();
        }
        System.out.printf("Bet %d points on this round. %n", bet);
    }

    public void greet(){
        System.out.printf("Hello, %s%s. Please choose a game to start.%n", name,
                (is_vip ? " the VIP":""));
    }
}
