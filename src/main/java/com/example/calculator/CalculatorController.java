package com.example.calculator;

public class CalculatorController {

    public long calculate(long op1, long op2, String operation) throws IllegalArgumentException{
        long result;
        switch (operation){
            case "+" -> result = plusOperation(op1, op2);
            case "-" -> result = minusOperation(op1, op2);
            case "/" -> result = divideOperation(op1, op2);
            default -> result = multiOperation(op1, op2);
        }
        return result;
    }

    private long plusOperation(long op1, long op2) {
       return op1+op2;
    }

    private long divideOperation(long op1, long op2) {
        if(op2 == 0) {
            throw new IllegalArgumentException();
        }
        return op1/op2;
    }

    private long multiOperation(long op1, long op2) {
      return op1*op2;
    }

    private long minusOperation(long op1, long op2) {
       return op1-op2;
    }

    public double calculateSingle(long op1, String operation) {
        double result;
        switch (operation){
            case "ln" -> result = lnOperation(op1);
            case "log" -> result = logOperation(op1);
            default -> result = radOperation(op1);
        }
        return result;
    }

    private double lnOperation(long op1) {
        if(op1 == 0) {
            throw new IllegalArgumentException();
        }
        return Math.log(op1);
    }

    private double logOperation(long op1) {
        if(op1 == 0) {
            throw new IllegalArgumentException();
        }
        return Math.log10(op1);
    }

    private double radOperation(long op1) {
        if(op1 < 0) {
            throw new IllegalArgumentException();
        }
        return Math.sqrt(op1);
    }

}
