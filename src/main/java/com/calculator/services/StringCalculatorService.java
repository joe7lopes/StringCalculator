package com.calculator.services;

public class StringCalculatorService {

    public int add(String s) {
        return s.isEmpty()?0:Integer.valueOf(s);
    }
}
