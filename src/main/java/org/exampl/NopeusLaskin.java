package org.exampl;

import java.util.Scanner;

public class NopeusLaskin {
    public static double milesToKilometers(double miles) {
        return miles * 0.62;

    }

    public static double kilometersToMiles(double kilometers) {
        return kilometers / 0.62;
    }

    public static double averageSpeed(double distance, double time) {
        if (time <= 0) {
            throw new IllegalArgumentException("Time must be greater than zero.");
        }
        return distance / time;

    }

    // Input: 300 K
    // Output: 26.85°C
    // Calculation: 300 - 273.15 = 26.85
    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter distance:");
        double distance = input.nextDouble();
        System.out.println("was the distance in (K)ilometers or (M)iles? :");
        char unit = input.next().toUpperCase().charAt(0);

        double distanceToKilometers;
        if (unit == 'M') {
            distanceToKilometers = milesToKilometers(distance);
            System.out.println("Distance is now in kilometers: " + distanceToKilometers);
        } else {
            distanceToKilometers = distance;

        }
        System.out.println("Enter time in hours:");
        double time = input.nextDouble();
        System.out.println("The average speed is : " + averageSpeed(distanceToKilometers, time));
    }

}