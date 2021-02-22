package com.praticals.ass2;
import java.util.Scanner;

public class q3_score {

    static boolean IsGame(String resultLine){
        final String VALID = "WDLwdl";
        for(char ch:resultLine.toCharArray()){
            if(VALID.indexOf(ch)==-1){
                return false;
            }
        }
        return true;
    }

    static int GameTotal(String resultLine){
        final String VALID = "WDLwdl";
        int score = 0;
        for(char ch:resultLine.toCharArray()){
            int scoreRemainder = VALID.indexOf(ch) % 3;
            switch (scoreRemainder){
                case 0:
                    score += 3;
                    break;
                case 1:
                    score += 1;
                    break;
                case 2:
                    break;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String usrLine;

        System.out.println("Enter a string representing any number of wins, " +
                "draws and losses e.g. \"WWDLDL\"");
//        do-while loop user input validation
        boolean firstRun = true;
        do {
            if(!firstRun){
                System.out.println("Invalid format, enter again.");
            }
            usrLine = scan.nextLine();
            firstRun = false;
        }while (!IsGame(usrLine));

        int scoreTotal=GameTotal(usrLine);
        int leng=usrLine.length();
        System.out.println("Total points: "+scoreTotal);
        System.out.println("Average points: "+((double)scoreTotal/(double) leng));
    }
}
