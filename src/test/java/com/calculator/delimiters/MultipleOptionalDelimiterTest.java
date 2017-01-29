package com.calculator.delimiters;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class MultipleOptionalDelimiterTest {

    private MultipleOptionalDelimiter testee;

    @Before
    public void setUp() {
        testee = new MultipleOptionalDelimiter();
    }

    @Test
    public void shouldAllowMultipleDelimiters() {
        String input = "//[*][%]\n1*2%3";
        assertDelimiters(input, "1*2%3", Arrays.asList("*", "%"));
    }

    @Test
    public void shouldAllowMultipleDelimitersOfAnyLength() {
        String input = "//[***][%]\n1***2%3";
        assertDelimiters(input, "1***2%3", Arrays.asList("***", "%"));
    }

    @Test
    public void shouldAllowDelimitersOfAnyLength() {
        String input = "//[***]\n1***2***3";
        assertDelimiters(input, "1***2***3", singletonList("***"));
    }

    private void assertDelimiters(String input, String cleanStr, List<String> delimiter) {
        DelimiterResult result = new DelimiterResult(delimiter, cleanStr);
        assertThat(testee.extract(input), equalTo(result));
    }

}