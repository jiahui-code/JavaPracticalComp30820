package com.praticals.p1;
import java.util.Scanner;

public class q6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number between 0 to 999:");
        short usrInput = scanner.nextShort();
        scanner.close();
        byte result = 0;

        while(usrInput > 0){
            result += (short)(usrInput % 10);
            usrInput = (short) (usrInput / 10);
        }

        System.out.println("Sum of all digits is " + result);
    }
}
