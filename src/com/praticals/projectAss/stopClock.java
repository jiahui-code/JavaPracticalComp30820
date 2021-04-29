package com.praticals.projectAss;

import java.util.Random;
import java.util.Scanner;

public class stopClock extends Game{

    stopClock(){
        super("Stop Clock");
        this.setDescription("Pause the invisible clock on required seconds, you win.");
    }

    @Override
    public void GameOn(User currentPlayer, Scanner scanSysIn) {

        //generate random half seconds
        Random rand = new Random();
        double targetTime = 3 + rand.nextInt(10) * 0.5;
        System.out.printf("Stop time on %.2f exactly.%n", targetTime);


        //only start on enter without other key stock
        String startSignal;
        do {
            System.out.println("Hit enter without any other key stroke whenever you are ready");
            startSignal = scanSysIn.nextLine();
        }while (!startSignal.isEmpty());

        System.out.println("... Time on ...");
        System.out.println("(Hit enter again to stop the clock.)");
        long startTime = System.currentTimeMillis();
        String endSignal = scanSysIn.nextLine(); // useless variable, only to detect enter stoke
        long endTime = System.currentTimeMillis();
        double timeElapsed = (endTime - startTime)/1000.0; // time in millisecond

        double gap = timeElapsed - targetTime;
        if (gap < -100 || gap > 100){   //debug
            System.out.printf("You failed. Your time is %.2f s. %n", timeElapsed);
        }else{
            System.out.println("You win!");
            // add bet points to player's account
            currentPlayer.winGame();
        }
    }
}
