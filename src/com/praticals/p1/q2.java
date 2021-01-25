package com.praticals.p1;
import java.util.Scanner; //for user prompt

public class q2 {
    public static void main(String[] args) {
        int iniPopul = 312_032_486;
        int dateOfYear = 365;
        int birthFreq = 7;
        int deathFreq = 13;
        int immigFreq = 45;
        int totalSec;

        System.out.print("Number of years passed:");
        Scanner myObj = new Scanner(System.in);
        int usrTime = myObj.nextInt();
        totalSec = usrTime * dateOfYear * 24 * 60 * 60;

        int resultPopul = iniPopul + totalSec / birthFreq
                - totalSec / deathFreq + totalSec / immigFreq;
        System.out.println("Current population is: "+ resultPopul);
    }
}
