package com.calculator.delimiters;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class MultipleOptionalDelimiterTest {

    private MultipleOptionalDelimiter testee;

    @Before
    public void setUp() {
        testee = new MultipleOptionalDelimiter();
    }

    @Test
    public void shouldAllowMultipleDelimiters() {
        String input = "//[*][%]\n1*2%3";
        assertNewDelimiters(input,"1*2%3", Arrays.asList("*","%"));
    }

    @Test
    public void shouldAllowMultipleDelimitersOfAnyLength() {
        String input = "//[***][%]\n1***2%3";
        assertNewDelimiters(input,"1***2%3", Arrays.asList("***","%"));
    }
    

    private void assertNewDelimiters(String input, String cleanStr, List<String> delimiter) {
        DelimiterExtractorResult result = new DelimiterExtractorResult(delimiter, cleanStr);
        assertThat(testee.extract(input), equalTo(result));
    }
    
}