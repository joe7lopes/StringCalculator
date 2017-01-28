package com.calculator.filters;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
class Bigger1000Filter implements NumbersFilter {

    @Override
    public List<Integer> filter(List<Integer> numbers) {
        return numbers.stream().filter(n -> n <= 1000).collect(Collectors.toList());
    }
}
