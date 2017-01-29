package com.calculator.validators;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NegativeNumbersValidator implements NumbersValidator {

    @Override
    public void validate(List<Integer> numbers) {

        List<Integer> negativeNumbers = numbers.stream().filter(n -> n < 0).collect(Collectors.toList());

        if (!negativeNumbers.isEmpty()) {
            throw new NegativeNumbersException(NEGATIVES_NOT_ALLOWED + getNegativeNumbersAsString(negativeNumbers));
        }
    }

    private String getNegativeNumbersAsString(List<Integer> negativeNumbers) {
        String negativeNumbersStr = "";

        for (Integer number : negativeNumbers) {
            negativeNumbersStr += number + " ";
        }
        return negativeNumbersStr;
    }

    public static class NegativeNumbersException extends RuntimeException {

        NegativeNumbersException(String message) {
            super(message);
        }
    }
}
