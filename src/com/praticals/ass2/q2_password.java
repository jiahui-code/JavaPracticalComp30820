package com.praticals.ass2;
import java.util.Scanner;

public class q2_password {
    static boolean is2Char(String pws){
        int count = 0;
        for(char ch:pws.toCharArray()){
            if (Character.isLetter(ch)) count++;
            if(count>=2) return true;
        }
        return false;
    }

    static boolean isCharOrDigit(String pws){
        for(char ch:pws.toCharArray()){
            if (Character.isLetter(ch)||Character.isDigit(ch)){;
            }else{return false;}
        }
        return true;
    }
    static boolean is3Digit(String pws){
        int count = 0;
        for(char ch:pws.toCharArray()){
            if (Character.isDigit(ch)) count++;
            if(count>=3) return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a password. ");
        String psw = scan.nextLine();

//        System.out.println(is2Char(psw));
//        System.out.println(isCharOrDigit(psw));
//        System.out.println(is3Digit(psw));

        boolean pwsValid =!(!is2Char(psw)||!isCharOrDigit(psw)||!is3Digit(psw));
        String valid = pwsValid ? "Valid ":"Invalid ";
        System.out.println(valid+"password.");
    }
}
