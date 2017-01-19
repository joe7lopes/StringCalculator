package com.calculator.services;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StringCalculatorServiceTest {

    private StringCalculatorService testee;

    @Before
    public void setUp() {
        testee = new StringCalculatorService();
    }

    @Test
    public void givenEmptyStringReturnZero() {
        assertThat(testee.add(""), is(0));
    }

    @Test
    public void givenOneNumberThenReturnThatNumber() {
        assertThat(testee.add("1"), is(1));
    }

}