package main.java.backend;

public class Calculator {
    public double add(double a, double b) {
        return a + b;
    }
    public double subtract(double a, double b) {
        return a - b;
    }
    public double multiply(double a, double b) {
        return a * b;
    }
    public double divide(double a, double b) {
        if (a == 0.0 || b == 0.0){
            throw new ArithmeticException("Divide by zero");
        }
        return a / b;
    }
    public double modulo(double a, double b) {
        if (a == 0.0 || b == 0.0){
            throw new ArithmeticException("Divide by zero");
        }
        return a % b;
    }
    public double faculty(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Negative number");
        }
        double result = 1;
        for (int i = 1; i <= a; i++) {
            result *= i;
        }
        return result;
    }
    public double power(double a, double b) {
        return Math.pow(a, b);
    }
}
