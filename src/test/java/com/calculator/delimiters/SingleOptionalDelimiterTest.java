package com.calculator.delimiters;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class SingleOptionalDelimiterTest {

    private SingleOptionalDelimiter testee;

    @Before
    public void setUp() {
        testee = new SingleOptionalDelimiter();
    }

    @Test
    public void givenNewDelimiterReturnStringWithThatDelimiter() {
        assertNewDelimiter("//;\n1;2", "1;2", ";");
        assertNewDelimiter("//*\n1*2", "1*2", "*");
    }

    @Test
    public void shouldHandleDelimiterOfAnyLength() {
        assertNewDelimiter("//***\n1***2", "1***2", "***");
    }

    private void assertNewDelimiter(String input, String cleanStr, String delimiter) {
        DelimiterExtractorResult result = new DelimiterExtractorResult(Collections.singletonList(delimiter), cleanStr);
        assertThat(testee.extract(input), equalTo(result));
    }


}