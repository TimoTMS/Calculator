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
}
