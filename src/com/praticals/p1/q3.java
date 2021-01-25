package com.praticals.p1;
import java.util.Scanner;

public class q3 {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.print("enter x1, y1, x2, y2:");
        double x1 = myObj.nextDouble();
        double y1 = myObj.nextDouble();
        double x2 = myObj.nextDouble();
        double y2 = myObj.nextDouble();

        //calculate
       double distance =Math.pow(Math.pow((x1-x2), 2) +
               Math.pow((y1-y2), 2), 0.5);
       System.out.println("The distance is:" + distance);
    }


}
