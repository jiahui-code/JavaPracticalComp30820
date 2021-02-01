package com.praticals.p2;
import java.util.Scanner;

public class q6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Which year is it? ");
        int userYear = scan.nextInt();

        if (userYear < 0 || userYear > 10000){
            System.out.println("It's not a correct year.");
        }
        int year12remain = userYear % 12;

        switch (year12remain){
            case 0:
                System.out.println("It's monkey year!");
                break;
            case 1:
                System.out.println("It's rooster year!");
                break;
            case 2:
                System.out.println("It's dog year!");
                break;
            case 3:
                System.out.println("It's pig year!");
                break;
            case 4:
                System.out.println("It's rat year!");
                break;
            case 5:
                System.out.println("It's ox year!");
                break;
            case 6:
                System.out.println("It's tiger year!");
                break;
            case 7:
                System.out.println("It's rabbit year!");
                break;
            case 8:
                System.out.println("It's dragon year!");
                break;
            case 9:
                System.out.println("It's snake year!");
                break;
            case 10:
                System.out.println("It's horse year!");
                break;
            case 11:
                System.out.println("It's sheep year!");
                break;
        }
    }
}
