package com.calculator.extractors;

import com.calculator.delimiters.Delimiter;
import com.calculator.delimiters.DelimiterExtractorResult;
import com.calculator.delimiters.DelimiterFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NumbersExtractorImplTest {

    private NumbersExtractorImpl testee;

    @Mock
    private Delimiter delimiter;
    @Mock
    private DelimiterFactory delimiterFactory;

    @Before
    public void setUp() {
        testee = new NumbersExtractorImpl(delimiterFactory);
        when(delimiterFactory.getDelimiter(anyString())).thenReturn(delimiter);
    }

    @Test
    public void givenTwoNumbersThenReturn() {
        String input = "1,2";
        DelimiterExtractorResult delimiterExtractorResult = new DelimiterExtractorResult(singletonList(","), "1,2");
        when(delimiter.extract(input)).thenReturn(delimiterExtractorResult);
        assertThat(testee.extract(input), is(Arrays.asList(1, 2)));
    }

    @Test
    public void givenOneDelimiterThenReturnNumbersAsInteger() {
        String input = "//;\n1;2";
        DelimiterExtractorResult delimiterExtractorResult = new DelimiterExtractorResult(singletonList(";"), "1;2");

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