package com.praticals.p3;
import java.util.Scanner;

public class q2_palindrome {
    public static boolean isPalindrome(String str){
        int charInd = 0, lstCharInd = str.length()-1, strLen=str.length();
        while(charInd<(strLen)/2){
            if(str.charAt(charInd)!=str.charAt(lstCharInd-charInd)){
                return false;
            }
            charInd ++;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true){
            String usrInput = scan.nextLine();
            System.out.println(isPalindrome(usrInput));
        }
    }

}
