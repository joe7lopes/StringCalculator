package com.calculator.delimiters;

import org.springframework.stereotype.Component;

import static java.util.Collections.singletonList;
@Component
class SimpleDelimiter implements Delimiter {

    @Override
    public DelimiterExtractorResult extract(String input) {

        String cleanInput = input.replace("\n", ",");

        return new DelimiterExtractorResult(singletonList(","), cleanInput);
    }
}
