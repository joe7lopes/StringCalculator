package com.calculator.delimiters;

import org.junit.Before;
import org.junit.Test;

import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class simpleDelimiterTest {

    private SimpleDelimiter testee;

    @Before
    public void setUp() {
        testee = new SimpleDelimiter();
    }

    @Test
    public void shouldReturnSum() {
        String input = "1,2,3,4";
        DelimiterResult result = new DelimiterResult(singletonList(","), "1,2,3,4");
        assertThat(testee.extract(input), equalTo(result));
    }

    @Test
    public void shouldAllowNewLineBetweenNumbers() {
        String input = "1\n2,3";
        DelimiterResult result = new DelimiterResult(singletonList(","), "1,2,3");
        assertThat(testee.extract(input), equalTo(result));
    }
}