package com.praticals.projectAss;

import java.util.Scanner;

public abstract class Game {
//    private int id;
    private String name;
    private String description;
    private int defaultScore = 3; // all game are set to default score 3

    Game(String name){ this.name = name; }
    Game(){this.name = "NA";}

//    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getDefaultScore() { return defaultScore; }

    public void setDescription(String description) {
        this.description = description;
    }

    public void describeGame(){
        System.out.printf("~~~~Short description for game %s ~~~~%n", this.getName());
        System.out.println(this.getDescription());
    }

    public abstract void GameOn(User currentPlayer, Scanner scanSysIn);
}
