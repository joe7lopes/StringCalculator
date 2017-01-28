package com.calculator.filters;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Bigger1000FilterTest {

    @Test
    public void shouldFilterNumbersBiggerThan1000() {
        Bigger1000Filter testee = new Bigger1000Filter();
        List<Integer> numbers = Arrays.asList(1, 2, -888, 1000, 1001, 5000);
        List<Integer> filteredNumbers = Arrays.asList(1, 2, -888, 1000);
        assertThat(testee.filter(numbers), is(filteredNumbers));
    }

}