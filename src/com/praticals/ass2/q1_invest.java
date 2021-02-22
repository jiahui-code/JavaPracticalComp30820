package com.praticals.ass2;
import java.util.Scanner;
import java.lang.Math;

public class q1_invest {
    static double ValueByMonth(double base, double monthRate, int yearDur){
//        get total value after specific year
        double totalMonth = (double) yearDur * 12;
        return base*(Math.pow((1+monthRate), totalMonth));
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("The amount invested: ");
        double moneyBase = scan.nextDouble();
        System.out.print("Annual interest rate: ");
        double yearRate = scan.nextDouble();
        boolean negativeInput = moneyBase<0 || yearRate<0;
        if (negativeInput) {
            System.out.println("Amount and annual rate must not be nagative.");
            System.exit(1);
        }

        System.out.printf("%-10s %-10s %n", "Years", "Values");
        for(int i=1; i<=30; i++){
            System.out.printf("%-10d %-10.2f %n",
                    i, ValueByMonth(moneyBase, yearRate/1200, i));
        }
    }

}
