package com.praticals.p1;
import java.util.Scanner;

public class q4 {
    public static void main(String[] args) {
        double tempFahren;
        double windSpeed;
        double windChillTemp;

        System.out.print("Enter a temperature between -54 to " +
                "41 Fahrenheit: ");
        Scanner myObj = new Scanner(System.in);
        tempFahren = myObj.nextDouble();
        System.out.print("Wind speed miles per hour >= 2:");
        windSpeed = myObj.nextDouble();

        windChillTemp = 35.74 + 0.6215 * tempFahren - 35.75 * Math.pow(
                windSpeed, 0.16) + 0.4275 * tempFahren * Math.pow(windSpeed, 0.16);

        System.out.println("Windchill temperature in such condition is "+
                windChillTemp);
    }
}
