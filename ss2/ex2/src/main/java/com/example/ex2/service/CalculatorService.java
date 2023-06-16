package com.example.ex2.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService{

    @Override
    public double calculate(double firstNum, double secondNum, String operator) throws Exception {
        switch (operator){
            case "+": return firstNum + secondNum;
            case "-": return firstNum - secondNum;
            case "*": return firstNum * secondNum;
            case "/":
                if(secondNum == 0) throw new ArithmeticException();
                else return firstNum / secondNum;
            default: throw new Exception("Wrong Operator!");
        }

    }
}
