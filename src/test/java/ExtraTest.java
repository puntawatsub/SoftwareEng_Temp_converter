
import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ExtraTest extends AbstractParent {

    private static Calculator calculator = new Calculator();
    private final double DELTA = 0.001;

    @BeforeAll
    public static void testPowerOn() {
        System.out.println("@BeforeAll Power ON (before the first test)");
        calculator.powerOn();
    }

    @AfterAll
    public static void testPowerOff() {
        System.out.println("@AfterAll Power OFF (all tests executed).");
        calculator.powerOff();
        calculator = null;
    }

    @BeforeEach
    public void testReset() {
        System.out.println("  Reset calculator.");
        calculator.reset();
        assertEquals(0, calculator.getResult(), DELTA, "Reset failed");
    }

    @ParameterizedTest(name = "Square of {0} is {1}")
    @CsvSource({"1, 1", "2, 4", "3, 9", "4, 16", "5, 25"})
    public void testSquare(double num, double result) {
        calculator.square(num);
        assertEquals(result, calculator.getResult(), DELTA, "Squaring number 2 is incorrect");
    }

    @Test
    public void testSquareRoot2() {
        calculator.squareRoot(2);
        // Add assertXXX() here, expected result should be (int) Math.sqrt(2)
        assertEquals(Math.sqrt(2), calculator.getResult(), DELTA, "Squaring number 2 is incorrect");
    }

    @Test
    @DisplayName("Test negative square root")
    public void testSquareRootNegative() {
        calculator.squareRoot(-2);
        assertEquals(NaN, calculator.getResult(), "Squaring number 2 is incorrect");
    }
}
