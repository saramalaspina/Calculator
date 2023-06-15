package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorGUIController {

    @FXML
    private TextField txt_result;

    private long number1;
    private long number2;
    private String operation;

    @FXML
    void number(ActionEvent event) {
        String txt = ((Button)event.getSource()).getText();
        if(txt_result != null) {
            txt = txt_result.getText().concat(txt);
        }
        txt_result.setText(txt);
    }

    @FXML
    void operation(ActionEvent event) {
        String btn = ((Button) event.getSource()).getText();
        try {
            switch (btn) {
                case "=" -> {
                    number2 = Long.parseLong(txt_result.getText());
                    CalculatorController calculatorController = new CalculatorController();
                    double result = calculatorController.calculate(number1, number2, operation);
                    txt_result.setText(String.valueOf(result));
                }
                case "Canc" -> txt_result.setText("");
                case "ln", "log", "√" -> {
                    number1 = Long.parseLong(txt_result.getText());
                    CalculatorController calculatorController = new CalculatorController();
                    double result = calculatorController.calculateSingle(number1, btn);
                    txt_result.setText(String.valueOf(result));
                }
                default -> {
                    number1 = Long.parseLong(txt_result.getText());
                    operation = btn;
                    txt_result.setText("");
                }
            }
        } catch (IllegalArgumentException e) {
            txt_result.setText("Error");
        }
    }
}
