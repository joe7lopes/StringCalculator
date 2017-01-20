package com.calculator.extractors;

import com.calculator.extractors.delimiter.Delimiter;
import com.calculator.extractors.delimiter.DelimiterExtractorResult;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NumbersExtractorImplTest {

    private NumbersExtractorImpl testee;

    @Mock
    private Delimiter delimiter;

    @Before
    public void setUp() {
        testee = new NumbersExtractorImpl(delimiter);
    }

    @Test
    public void givenOneDelimiterThenReturnNumbersAsInteger() {
        String input = "//;\n1;2";
        DelimiterExtractorResult delimiterExtractorResult = new DelimiterExtractorResult(Arrays.asList(";"), "1;2");

        when(delimiter.extract(input)).thenReturn(delimiterExtractorResult);

        assertThat(testee.extract(input), is(Arrays.asList(1, 2)));
    }

    @Test
    public void givenMultipleDelimitersThenReturnNumbersAsInteger() {
        String input = "//[*][%]\n1*2%3";
        DelimiterExtractorResult delimiterExtractorResult = new DelimiterExtractorResult(Arrays.asList("*", "%"), "1*2%3");

        when(delimiter.extract(input)).thenReturn(delimiterExtractorResult);

        assertThat(testee.extract(input), is(Arrays.asList(1, 2, 3)));
    }
}