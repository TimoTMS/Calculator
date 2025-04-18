package main.java.controller;

import javafx.fxml.FXML;
import main.java.backend.Calculator;

import java.awt.*;
import java.awt.event.ActionEvent;

public class MainViewController{


    @FXML
    private TextField displayField;

    private Calculator calculator = new Calculator();

    private final Calculator calculator = new Calculator();
    private boolean startNewInput = true;

    @FXML
    private void initialize() {
        // Initialize the calculator
        displayField.setEditable(false);
    }

    @FXML
    private void handleNumberButtonAction(ActionEvent event) {
        String buttonText = ((Button) event.getSource()).getText();
        if (startNewInput) {
            currentInput = buttonText;
            startNewInput = false;
        } else {
            currentInput += buttonText;
        }
        displayField.setText(currentInput);
    }

    @FXML
    private void handleDecimalButtonAction(ActionEvent event) {
        if (startNewInput) {
            currentInput = "0.";
            startNewInput = false;
        } else if (!currentInput.contains(".")) {
            currentInput += ".";
        }
        displayField.setText(currentInput);
    }

    @FXML
    private void handleOperatorButtonAction(ActionEvent event) {
        String buttonText = ((Button) event.getSource()).getText();
        if (!currentInput.isEmpty()) {
            firstOperand = Double.parseDouble(currentInput);
            currentOperator = buttonText;
            currentInput = "";
            startNewInput = true;
        }
    }

    @FXML
    private void handleEqualsButtonAction(ActionEvent event) {
        if (!currentInput.isEmpty() && !currentOperator.isEmpty()) {
            double secondOperand = Double.parseDouble(currentInput);
            double result = 0;
            switch (currentOperator) {
                case "+" -> result = calculator.add(firstOperand, secondOperand);
                case "-" -> result = calculator.subtract(firstOperand, secondOperand);
                case "*" -> result = calculator.multiply(firstOperand, secondOperand);
                case "/" -> {
                    if (secondOperand == 0) {
                        displayField.setText("Error");
                        return;
                    }
                    result = calculator.divide(firstOperand, secondOperand);
                }
                case "%" -> {
                    if (secondOperand == 0) {
                        displayField.setText("Error");
                        return;
                    }
                    result = calculator.modulo(firstOperand, secondOperand);
                }
                default -> throw new UnsupportedOperationException("Unknown operator: " + currentOperator);
            }
            displayField.setText(String.valueOf(result));
            currentInput = String.valueOf(result);
            currentOperator = "";
            startNewInput = true;
        }
    }

    @FXML
    private void handleClearButtonAction(ActionEvent event) {
        currentInput = "";
        firstOperand = 0;
        currentOperator = "";
        startNewInput = true;
        displayField.setText("0");
    }

    // Toggle button to change the sign of the current input +/-
    @FXML
    private void handleToggleButtonAction(ActionEvent event) {
        if (!currentInput.isEmpty()) {
            double value = Double.parseDouble(currentInput);
            value = -value;
            currentInput = String.valueOf(value);
            displayField.setText(currentInput);
        }
    }

    @FXML

    @FXML
    private Button addButton;

    @FXML
    private Button subtractButton;

    @FXML
    private Button multiplyButton;

    @FXML
    private Button divideButton;

    @FXML
    private Button moduloButton;

    @FXML
    private Button equalsButton;

    @FXML
    private Button clearButton;

    @FXML
    private Button decimalButton;

    @FXML
    private Button zeroButton;

    @FXML
    private Button oneButton;

    @FXML
    private Button twoButton;

    @FXML
    private Button threeButton;

    @FXML
    private Button fourButton;

    @FXML
    private Button fiveButton;

    @FXML
    private Button sixButton;

    @FXML
    private Button sevenButton;

    @FXML
    private Button eightButton;

    @FXML
    private Button nineButton;

    @FXML
    private Button negativeButton;

}
