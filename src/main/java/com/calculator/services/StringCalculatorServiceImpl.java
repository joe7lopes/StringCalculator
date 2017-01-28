package com.calculator.services;

import com.calculator.extractors.NumbersExtractor;
import com.calculator.filters.NumbersFilter;
import com.calculator.validators.NumbersValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StringCalculatorServiceImpl implements StringCalculatorService {

    private NumbersExtractor numbersExtractor;
    private NumbersValidator numbersValidator;
    private NumbersFilter numbersFilter;

    @Autowired
    public StringCalculatorServiceImpl(NumbersExtractor numbersExtractor, NumbersValidator numbersValidator, NumbersFilter numbersFilter) {
        this.numbersExtractor = numbersExtractor;
        this.numbersValidator = numbersValidator;
        this.numbersFilter = numbersFilter;
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
        numbersValidator.validate(numbers);
        numbers = numbersFilter.filter(numbers);
        for (Integer number : numbers) {
            result += number;
        }
        return result;
    }
}
