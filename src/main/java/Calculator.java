

public class Calculator {

    private double result;    // Variable for the result

    public void reset() {  // Resets the result variable
        result = 0;
    }

    public double getResult() {
        return result;
    }

    public void add(double n) {
        result = result + n;
    }

    public void subtract(double n) {
        result = result - n;
    }

    public void multiply(double n) {
        // Not implemented yet
        result = result * n;
    }

    public void divide(double n) {
        if (n == 0) throw new ArithmeticException("Cannot divide by zero");
        result = result / n;
    }

    public void square(double n) {
        result = n * n;
    }

    public void squareRoot(double n) {
        // Not implemented yet
        result = Math.sqrt(n);
    }

    public void powerOn() {
        // Initial actions could be placed here
        result = 0;
    }

    public void powerOff() {
        // Final actions could be placed here
    }

    public double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

}
