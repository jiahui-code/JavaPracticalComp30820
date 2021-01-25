package com.praticals.p1;
import java.util.Scanner; //import

public class q1 {
    public static void main(String[] args) {
        System.out.println("test");

        //user prompt and needed inputs
        Scanner myObj = new Scanner(System.in);
        //create a scanner object
        System.out.print("Enter your radius:");
        double radius = myObj.nextDouble();
        System.out.print("Enter your height:");
        double height = myObj.nextDouble();

        //calculate and print area and volume
        System.out.println("Area of your circle is " + Math.PI * Math.pow(radius, 2));
        System.out.print("Volume of your cylinder is " + Math.PI * Math.pow(radius, 2) * height);
    }
}
