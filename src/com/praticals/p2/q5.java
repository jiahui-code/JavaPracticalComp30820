package com.praticals.p2;
import java.util.Scanner;

public class q5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a character: ");
        char ch = input.next().charAt(0);

        if (! Character.isLetter(ch)){
            System.out.println(ch+" is not a letter.");
        }else if ("AEIOUaeiou".indexOf(ch) == -1){
            System.out.println(ch+" is a consonant.");
        }else {
            System.out.println(ch+" is a vowel.");
        }
    }
}
