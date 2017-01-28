package com.calculator.validators;

import java.util.List;

public interface NumbersValidator {
    String NEGATIVES_NOT_ALLOWED = "Negatives not allowed: ";
    void validate(List<Integer> numbers);
}
