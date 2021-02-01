package com.praticals.p2;
import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter 3 sides of your triangle:");

        int side1 = scan.nextInt();
        int side2 = scan.nextInt();
        int side3 = scan.nextInt();
//        check for all positive number
        if (! (side1 > 0 && side2 > 0 && side3 > 0)){
            System.out.println("All sides must be positive.");
        }
        if (side1 + side2 > side3 && side1 + side3 > side2 && side2 +
        side3 > side1){
            System.out.println("The perimeter of the triangle is "+(side1+side2+
            side3));
        }
        else{System.out.println("every pairof the lengths of two sides " +
                "is greater than the length of the remaining side. ");}

    }
}
