package com.calculator.services;

import com.calculator.extractors.NumbersExtractorImpl;

import java.util.List;

public class StringCalculatorServiceImpl implements StringCalculatorService {

    private NumbersExtractorImpl numbersExtractor;

    public StringCalculatorServiceImpl(NumbersExtractorImpl numbersExtractor) {
        this.numbersExtractor = numbersExtractor;
    }

    @Override
    public int add(String input) {
        return isEmpty(input) ? 0 : sum(input);
    }

    private boolean isEmpty(String input) {
        return null == input || input.isEmpty();
    }

    private int sum(String input) {
        int result = 0;
        List<Integer> numbers = numbersExtractor.extract(input);
        for (Integer number : numbers) {
            result += number;
        }
        return result;
    }
}
