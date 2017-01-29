package com.calculator.delimiters;

import org.springframework.stereotype.Component;

import static java.util.Collections.singletonList;
@Component
class SimpleDelimiter implements Delimiter {

    @Override
    public DelimiterResult extract(String input) {

        String inputWithoutDelimiterPrefix = input.replace("\n", ",");

        return new DelimiterResult(singletonList(","), inputWithoutDelimiterPrefix);
    }
}
