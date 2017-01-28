package com.calculator.delimiters;

import org.junit.Test;

import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class simpleDelimiterTest {


    @Test
    public void shouldAllowNewLineBetweenNumbers() {
        SimpleDelimiter testee = new SimpleDelimiter();
        String input = "1\n2,3";
        DelimiterExtractorResult result = new DelimiterExtractorResult(singletonList(","), "1,2,3");

        assertThat(testee.extract(input), equalTo(result));
    }
}