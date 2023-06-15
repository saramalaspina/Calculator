package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorGUIController {

    @FXML
    private TextField txtResult;

    private long number1;
    private long number2;
    private String operation;

    @FXML
    void number(ActionEvent event) {
        String txt = ((Button)event.getSource()).getText();
        if(txtResult != null) {
            txt = txtResult.getText().concat(txt);
        }
        txtResult.setText(txt);
    }

    @FXML
    void operation(ActionEvent event) {
        String btn = ((Button) event.getSource()).getText();
        try {
            switch (btn) {
                case "=" -> {
                    number2 = Long.parseLong(txtResult.getText());
                    CalculatorController calculatorController = new CalculatorController();
                    long result = calculatorController.calculate(number1, number2, operation);
                    txtResult.setText(String.valueOf(result));
                }
                case "Canc" -> txtResult.setText("");
                case "ln", "log", "√" -> {
                    number1 = Long.parseLong(txtResult.getText());
                    CalculatorController calculatorController = new CalculatorController();
                    long result = (long) calculatorController.calculateSingle(number1, btn);
                    txtResult.setText(String.valueOf(result));
                }
                default -> {
                    number1 = Long.parseLong(txtResult.getText());
                    operation = btn;
                    txtResult.setText("");
                }
            }
        } catch (IllegalArgumentException e) {
            txtResult.setText("Error");
        }
    }
}
