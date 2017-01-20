package com.calculator.services;

import com.calculator.extractors.NumbersExtractorImpl;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StringCalculatorServiceImplTest {

    private StringCalculatorServiceImpl testee;
    @Mock
    private NumbersExtractorImpl numbersExtractor;


    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        testee = new StringCalculatorServiceImpl(numbersExtractor);
    }

    @Test
    public void givenNullReturnZero() {
        assertThat(testee.add(null), is(0));
    }

    @Test
    public void givenEmptyStringReturnZero() {
        assertThat(testee.add(""), is(0));
    }

    @Test
    public void givenOneNumberThenReturnThatNumber() {
        String input = "1";
        when(numbersExtractor.extract(input)).thenReturn(singletonList(1));
        assertThat(testee.add(input), is(1));
    }

    @Test
    public void givenTwoNumbersThenSum() {
        String input = "1,2";
        when(numbersExtractor.extract(input)).thenReturn(Arrays.asList(1, 2));
        assertThat(testee.add(input), is(3));
    }

    @Test
    public void ShouldSumMultipleNumbers() {
        //Usually there's only one assertion per method,
        //But given the problem this is acceptable. Otherwise we would have
        //to use Parametrized tests.
        assertSum("1,2,4,6", 13);
        assertSum("2,2,4,0", 8);
        assertSum("100,82,9,3", 194);
    }

    @Test
    public void givenNewLineThenSum() {
        String input = "1\n2,4";
        when(numbersExtractor.extract(input)).thenReturn(Arrays.asList(1, 2, 4));
        assertThat(testee.add(input), is(7));
    }

    @Ignore
    public void givenInvalidInputThenException() {
        exception.expect(NumberFormatException.class);
        testee.add("1,\n");
    }

    /*
        @Test
        public void givenNewDelimiterThenSum() {
            String newDelimiter= "//;\n";
            assertThat(testee.add(newDelimiter+"2;1"),is(3));
        }
    */
    private void assertSum(String input, int result) {
        List<Integer> numbers = new ArrayList<>(input.length());
        for (String number : input.split(",")) {
            numbers.add(Integer.valueOf(number));
        }
        when(numbersExtractor.extract(input)).thenReturn(numbers);
        assertThat(testee.add(input), is(result));
    }
}