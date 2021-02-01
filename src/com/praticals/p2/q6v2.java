package com.praticals.p2;
import java.util.Scanner;

public class q6v2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Which year is it? ");
        int userYear = scan.nextInt();

        if (userYear < 0 || userYear > 10000){
            System.out.println("It's not a correct year.");
        }
        int year12remain = userYear % 12;

        if (year12remain == 0){
            System.out.println("It's monkey year!");
        } else if (year12remain == 1) {
            System.out.println("It's rooster year!");
        }else if (year12remain == 2){
            System.out.println("It's dog year!");
        }else if (year12remain == 3){
            System.out.println("It's pig year!");
        }else if (year12remain == 4){
            System.out.println("It's rat year!");
        }else if (year12remain == 5){
            System.out.println("It's ox year!");
        }else if (year12remain == 6){
            System.out.println("It's tiger year!");
        }else if (year12remain == 7){
            System.out.println("It's rabbit year!");
        }else if (year12remain == 8){
            System.out.println("It's dragon year!");
        }else if (year12remain == 9){
            System.out.println("It's snake year!");
        }else if (year12remain == 10){
            System.out.println("It's horse year!");
        }else{
            System.out.println("It's sheep year!");
        }
    }
}
