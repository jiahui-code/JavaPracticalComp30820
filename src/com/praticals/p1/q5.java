package com.praticals.p1;

import java.util.Scanner;

public class q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Distance to drive: ");
        int distance = scanner.nextInt();
        System.out.print("Fuel efficiency of the car in miles per gallon: ");
        float fuelEfficiency = scanner.nextFloat();
        System.out.print("Fuel price per gallon: ");
        float fuelPrice = scanner.nextFloat();

        scanner.close();

        float tripCost = (float) distance * fuelEfficiency * fuelPrice;
        System.out.println("Total price for the trip is "+tripCost);

    }
}
