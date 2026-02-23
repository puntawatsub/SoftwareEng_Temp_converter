package org.exampl;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class NopeusLaskinTest {

    @Test
    void testMilesToKilometers() {
        double miles = 10.0;
        double expectedKm = 6.2;

        double result = NopeusLaskin.milesToKilometers(miles);

        assertEquals(expectedKm, result, 0.0001);
    }

    @Test
    void testKilometersToMiles() {
        double kilometers = 6.2;
        double expectedMiles = 10.0;

        double result = NopeusLaskin.kilometersToMiles(kilometers);

        assertEquals(expectedMiles, result, 0.0001);
    }

    @Test
    void testAverageSpeedNormalCase() {
        double distance = 100.0;
        double time = 2.0;
        double expectedSpeed = 50.0;

        double result = NopeusLaskin.averageSpeed(distance, time);

        assertEquals(expectedSpeed, result, 0.0001);
    }

    @Test
    void testAverageSpeedThrowsExceptionWhenTimeIsZero() {
        double distance = 100.0;
        double time = 0.0;

        assertThrows(IllegalArgumentException.class, () -> {
            NopeusLaskin.averageSpeed(distance, time);
        });
    }

    @Test
    void testAverageSpeedThrowsExceptionWhenTimeIsNegative() {
        double distance = 100.0;
        double time = -5.0;

        assertThrows(IllegalArgumentException.class, () -> {
            NopeusLaskin.averageSpeed(distance, time);
        });
    }

    @Test
    void kelvinToCelsius() {
        double kelvin = 300;
        assertEquals(26.85, NopeusLaskin.kelvinToCelsius(kelvin), 0.01);
    }
}
