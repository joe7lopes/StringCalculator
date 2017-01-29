package com.calculator.delimiters;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class DelimiterFactoryTest {
    private DelimiterFactory testee;
    @Mock
    private SimpleDelimiter simpleDelimiter;
    @Mock
    private SingleOptionalDelimiter singleOptionalDelimiter;
    @Mock
    private MultipleOptionalDelimiter multiOptionalDelimiter;

    @Before
    public void setUp() {
        testee = new DelimiterFactory(simpleDelimiter,singleOptionalDelimiter,multiOptionalDelimiter);
    }

    @Test
    public void givenSimpleInputReturnSimpleDelimiter() {
        String input = "1\n2,3";
        assertThat(testee.getDelimiter(input), instanceOf(SimpleDelimiter.class));
    }

    @Test
    public void givenOneOptionalDelimiterReturnSingleOptionalDelimiter() {
        String input = "//;\\n1;2";
        assertThat(testee.getDelimiter(input), instanceOf(SingleOptionalDelimiter.class));
    }

    @Test
    public void givenTwoDelimitersThenReturnMultipleOptionalDelimiter() {
        String input = "//[*][%]\n1*2%3";
        assertThat(testee.getDelimiter(input), instanceOf(MultipleOptionalDelimiter.class));
    }

    @Test
    public void givenDelimiterOfAnyLenghtThenReturnMultipleOptionalDelimiter() {
        String input = "//[***]\n1***2***3";
        assertThat(testee.getDelimiter(input), instanceOf(MultipleOptionalDelimiter.class));
    }

}