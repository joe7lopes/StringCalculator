package com.calculator.validators;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

public class NegativeNumbersValidatorTest {

    private NegativeNumbersValidator testee;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        testee = new NegativeNumbersValidator();
    }

    @Test
    public void givenOneNegativeNumberThenException() {
        List<Integer> numbers = Arrays.asList(1, 2, -3, 0);
        exception.expect(NegativeNumbersValidator.NegativeNumbersException.class);
        exception.expectMessage("Negatives not allowed -3");
        testee.validate(numbers);
    }

    @Test
    public void givenTwoNegativeNumberThenException() {
        List<Integer> numbers = Arrays.asList(1, -2, -3, 0, -102);
        exception.expect(NegativeNumbersValidator.NegativeNumbersException.class);
        exception.expectMessage("Negatives not allowed -2 -3 -102");
        testee.validate(numbers);
    }

    @Test
    public void givenNoNegativeNumbersThenReturn() {
        List<Integer> numbers = Arrays.asList(1, 0, 102);
        testee.validate(numbers);
    }
}