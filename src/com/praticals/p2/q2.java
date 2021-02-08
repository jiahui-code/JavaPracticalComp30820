package com.praticals.p2;
import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the length from the center of a pentagon to a vertex:");

        double usrLen = scan.nextFloat();
        if (usrLen <= 0 || usrLen > 1000){
            System.out.println("Length must be in range 0-1000.");
            System.exit(0);
        }

        double vertexArea = 5 * Math.pow(usrLen, 2)/(4 * Math.tan(Math.PI/5));
        System.out.println("Area of the vertex is "+vertexArea);
    }
}
